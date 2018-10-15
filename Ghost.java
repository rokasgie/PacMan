package java;

import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * 
 * @author Rokas Giedraitis
 */
public class Ghost extends Actor
{   
    private static int ghosts = 0;
    public static int powerUpLength = 0;
    
    public int startX, startY;
    public boolean dead;
    public boolean powerUp;
    public int powerUpCount;
    public GreenfootImage startImg;
    
    private int ghostNr, dir, speed, powerUpImg, powerUpImgCount, deadCount; 
    private GreenfootImage img;
    
    Ghost(int speed)
    {
        this.speed = speed;
        this.ghostNr = Ghost.ghosts;
        this.dir = this.ghostNr;
        Ghost.ghosts = Ghost.ghosts + 1;
        this.powerUpImgCount = 0;
        this.powerUpImg = 0;
        this.dead = false;
        this.powerUp = false;
        
        this.img = this.startImg = new GreenfootImage("images\\Ghosts\\Ghost" + ghostNr + "." + dir + ".png");
        setImage(this.img);
    }
        
    @Override
    public void act() 
    {               
        if(!dead)
        {
            setImage();            
            checkPacman();
            movement(speed);
        }
        else
        {
            this.deadCount++;
            if(this.deadCount == 150)
            {
                setLocation(this.startX, this.startY);
                img.setTransparency(255);
                setImage(this.startImg);
                this.dead = false;
            }    
        }
    } 
    
    private void movement(int speed)
    {
        int dx, dy;
        
        if (dir % 2 == 0) {
            dx = (1 - dir) * speed;
            dy = 0;
        } else {
            dx = 0;
            dy = (2 - dir) * speed;
        }
        
        AI(dx, dy);
    }
        
    private void AI(int dx, int dy)
    {
        int x = getX();
        int y = getY();
        boolean moved = false;
        
        List <Pair<Integer, Integer>> vietos = getOptions(x, y, dx, dy);
        Pair<Integer, Integer> vieta;
        int n = vietos.size();
        
        List <PacMan> list = getObjectsInRange(Levels.range, PacMan.class);
        
        if(list.isEmpty())
        {
            if(n > 0)
            {
                int ran = Greenfoot.getRandomNumber(n);
                vieta = vietos.get(ran);
                x = vieta.getKey();
                y = vieta.getValue();
                moved = true;
            }
        }
        else
        {
            Actor pacman = list.get(0);
            int px = pacman.getX();
            int py = pacman.getY();
            
            double distance;
            double min = StartScreen.height;
            double max = 0;
            
            for(int i = 0; i < n; i++)
            {
                vieta = vietos.get(i);
                distance = Math.sqrt(Math.pow(vieta.getKey() - px, 2) + Math.pow(vieta.getValue() - py, 2));
                
                if(powerUp)
                {
                    if(distance >= max)
                    {
                        max = distance;
                        x = vieta.getKey();
                        y = vieta.getValue();
                        moved = true;
                    }   
                }
                else
                {
                    if(distance <= min)
                    {
                        min = distance;
                        x = vieta.getKey();
                        y = vieta.getValue();
                        moved = true;
                    }   
                }   
            }
        }
        
        if(!moved)
        {
            x = x - dx;
            y = y - dy;
        }

        dir = getDirection(x, y);
        setLocation(x, y);
    }
    
    private List getOptions(int x, int y, int dx, int dy)
    {
        List<Pair<Integer, Integer>> vietos = new ArrayList<>();
        int n = 0;
           
        setLocation(x + dx, y + dy);
        Actor wall = getOneIntersectingObject(Wall.class);
        if(null == wall)
        {
            vietos.add(n++, new Pair(x + dx, y + dy));                  
        }
        
        setLocation(x + dy, y + dx);
        wall = getOneIntersectingObject(Wall.class);
        if(null == wall)
        {
            vietos.add(n++, new Pair(x + dy, y + dx));
        }
        
        setLocation(x - dy, y - dx);
        wall = getOneIntersectingObject(Wall.class);
        if(null == wall)
        {
            vietos.add(n++, new Pair(x - dy, y - dx));
        }
        
        setLocation(x, y);        
        return vietos;
    }
    
    private int getDirection(int x, int y)
    {
        turnTowards(x, y);
        int rot = (int) (getRotation() / 90);
        turnTowards(StartScreen.width, getY());
        return rot;
    }
    
    private void checkPacman()
    {
        Actor pacman = getOneObjectAtOffset(0, 0, PacMan.class);
        if(null != pacman)
        {
            if(powerUp)
            {
                Levels.overallScore = Levels.overallScore + 200;
                this.deadCount = 0;
                img.setTransparency(0);
                setImage(img);
                this.dead = true; 
                this.powerUp = false;
                this.powerUpImgCount = 0;
            }
            else
            {
                PacMan.lives--;
                Greenfoot.delay(30);
                Levels.resetLevel = true;
            }    
        }
    }
        
    private void powerUp()
    {
        if(this.powerUpCount == Ghost.powerUpLength)
        {
            this.powerUp = false;
            this.powerUpImgCount = 0;
        }
        else this.powerUpCount++;    
    }
    
    private void setImage()
    {
        if (powerUp) 
        {
            powerUp();

            if (powerUpImgCount == 8) 
            {
                this.img = new GreenfootImage("images\\Ghosts\\GhostDead" + powerUpImg + " 40x40.png");
                setImage(new GreenfootImage("images\\Ghosts\\GhostDead" + powerUpImg + " 40x40.png"));
                powerUpImg = (powerUpImg + 1) % 2;
                powerUpImgCount = 0;
            }
            else 
            {
                powerUpImgCount++;
            }
        }
        else 
        {
            this.img = new GreenfootImage("images\\Ghosts\\Ghost" + ghostNr + "." + dir + ".png");
            setImage(new GreenfootImage("images\\Ghosts\\Ghost" + ghostNr + "." + dir + ".png"));
        }
    }
}
