package java;

import greenfoot.*;

/**
 * 
 * @author Rokas Giedraitis
 */
public class Levels extends World{
    
    public static int levelScore, maxScore;
    public static int overallScore, range;
    public static boolean resetLevel;
    protected int x1, y1, x2, y2, x3, y3; 
    
    private static Levels currLevel;
    private static int level;
    
    private GreenfootImage img;
    private static Lives lives;
    private static Score score;
    protected static PacMan pacman;
    protected static PowerUp[] powerUp;
    protected static Ghost[] ghost;


    public Levels()
    {
        super(StartScreen.width, StartScreen.height, 1);
        Levels.levelScore = Levels.maxScore = 0; 
        Levels.level = 0;
        createObjects(2);
    }
    
    public Levels(int range, int maxScore)
    {
        super(StartScreen.width, StartScreen.height, 1); 
        setBackground();
        addObject(Levels.lives, 50, 15);
        addObject(Levels.score, StartScreen.width - 75, 15);
        
        Levels.levelScore = 0;
        Levels.range = range;  
        Levels.maxScore = maxScore; 
    }
     
    @Override
    public void act()
    {
        if(PacMan.lives < 1) Greenfoot.setWorld(new End());
        
        if(Levels.maxScore <= Levels.levelScore)
        {
            Levels.level++;
            
           switch(Levels.level)
            {
                case 1:
                    Levels.currLevel = new Level1();
                    Greenfoot.setWorld(currLevel);
                    break;
                case 2:
                    Levels.currLevel = new Level2();
                    Greenfoot.setWorld(currLevel);
                    break;
                case 3:
                    Levels.currLevel = new Level3();
                    Greenfoot.setWorld(currLevel);
                    break;
                case 4:
                    Greenfoot.setWorld(new Victory());
            }         
        }
        
        Levels.lives.update();
        Levels.score.update();
        
        if(PowerUp.act)
        {
            powerUp();
        }
        
        if(Levels.resetLevel  && PacMan.lives > 0) resetLevel(true);
    }
    
     protected void addRow(int x, int y, int length)
    {
        x = Wall.krastine * x + Wall.krastine;
        y = Wall.krastine * y + Wall.krastine + StartScreen.border; 
        for(int i = 0; i < length; i++)
        {
            Wall wall = new Wall(1, 1);
            addObject(wall, x, y);
            x = x + Wall.krastine;
        }      
    }
    
    protected void addColumn(int x, int y, int length)
    {
        x = Wall.krastine * x + Wall.krastine;
        y = Wall.krastine * y + Wall.krastine + StartScreen.border; 
        for(int i = 0; i < length; i++)
        {
            Wall wall = new Wall(1, 1);
            addObject(wall, x, y);
            y = y + Wall.krastine;
        }     
    }
    
    protected void addWalls()
    {   
        Wall wall; 
        int x = Wall.krastine/2;
        int y = Wall.krastine/4 + StartScreen.border;
        for(int i = 0; i <= StartScreen.width/Wall.krastine; i++)
        {
            wall = new Wall(1, 0.5);
            addObject(wall, x, y);
            wall = new Wall(1, 0.5);
            addObject(wall, x, StartScreen.height - y + StartScreen.border);
            x = x + Wall.krastine;            
        }
        
        x = Wall.krastine/4;
        y = Wall.krastine/2 + StartScreen.border;
        for(int i = 0; i <= StartScreen.height/Wall.krastine; i++)
        {
            wall = new Wall(0.5, 1);
            addObject(wall, x, y);
            wall = new Wall(0.5, 1);
            addObject(wall, StartScreen.width - x, y);
            y = y + Wall.krastine;            
        } 
    }
    
    protected void fillFood()
    {
        int l = StartScreen.width/Wall.krastine - 1;
        int h = (StartScreen.height - StartScreen.border)/Wall.krastine - 1;
        
        int x;
        int d = Wall.krastine;
        int y = (int)(1.5 * Wall.krastine) + StartScreen.border;
                     
        Actor food;
        for(int i = 0; i < h; i++)
        {
            x = (int)(1.5 * Wall.krastine);
            for(int j = 0; j < l; j++)
            {
                food = new Food();
                addObject(food, x, y);
                x = x + d;
            } 
            y = y + d;
        }
    } 
    
    private void setBackground() 
    {
        this.img = new GreenfootImage(StartScreen.width, StartScreen.height);
        this.img.fill();
        setBackground(this.img);
    }
    
    private void createObjects(int ghostSpeed)
    {
        
        Levels.pacman = new PacMan();
        Levels.lives = new Lives();
        Levels.score = new Score();
        Levels.powerUp = new PowerUp[4];
        Levels.ghost  = new Ghost[4];
        
        for(int i = 0; i < 4; i++)
        {
            ghost[i] = new Ghost(ghostSpeed);
            powerUp[i] = new PowerUp();
            
        }  
    }
        
    public void setLocations(int a, int b, int c, int d, int e, int f)
    {
        int x, y;
        for(int i = 0; i < 4; i++)
        {
            if(i%2 == 0) x = a;
            else x = c;
            if(i < 2) y = b;
            else y = d;
            
            ghost[i].startX = x;
            ghost[i].startY = y;
            
            
            powerUp[i].setLocation(x, y);
            ghost[i].setLocation(x, y);
        }
       
        pacman.setLocation(e, f);
        pacman.setRotation(0);
        pacman.dx = 1;
        pacman.dy = 0;
    }
    
    protected void addActors()
    {
        for (int i = 0; i < 4; i++) 
        {
            addObject(powerUp[i], 0, 0);
            addObject(ghost[i], 0, 0);         
        }
         addObject(pacman, 0, 0);

    }
    
    protected void resetLevel(boolean delay)
    {
        //Greenfoot.setWorld(currLevel);
        setLocations(x1, y1, x2, y2, x3, y3);
        pacman.dx = 1;
        pacman.dy = 0;
        pacman.setRotation(0);
        Levels.resetLevel = false;
        
        for(int i = 0; i < 4; i++)
        {
            ghost[i].dead = false;
            ghost[i].powerUp = false;
            ghost[i].powerUpCount = 0;
            ghost[i].setImage(ghost[i].startImg);
        } 
        if(delay) Greenfoot.delay(50);  
    }
    
    private void powerUp()
    {
        for(int i = 0; i < 4; i++)
        {
            if(!ghost[i].dead)
            {
                ghost[i].powerUp = true;
                ghost[i].powerUpCount = 0;
            }
        }
        PowerUp.act = false;
    }
}
