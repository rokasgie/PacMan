package java;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * 
 * @author Rokas Giedraitis
 */
public class PacMan extends Actor
{
    final private String file = "images\\PacMan\\PacMan";
    final private int width = 38;
    public static int lives;
    
    private boolean isDown = false;
    static boolean dead = false;
    
    public int dx = 1, dy = 0;
    private int eatImgCount, eatImg;
    private final int speed, help;
    
    PacMan()
    {
        this.speed = 3;
        this.help = 2;
        PacMan.lives = 3;
        
        setImage(new GreenfootImage(file + eatImg + " " + width  + "x" + width + ".png"));
        setRotation(0);
    }
               
    @Override
    public void act()
    {
        movement();
        checkFood();
        
        if (this.eatImgCount == 8) 
        {
            setImage(new GreenfootImage(file + eatImg + " " + width + "x" + width + ".png"));
            eatImg = (eatImg + 1) % 2;
            this.eatImgCount = 0;
        } 
        else 
        {
            this.eatImgCount++;
        }            
    }
    
    private void movement()
    {
        checkForWall(dx, dy); 
        
        if (Greenfoot.isKeyDown("right") && !isDown)
        {
            if(checkDirection(1, 0))
            {
                this.dx = 1;
                this.dy = 0;
                setRotation(0);
            }    
        }
        else if (Greenfoot.isKeyDown("down") && !isDown)
        {
            if(checkDirection(0, 1))
            {
                this.dx = 0;
                this.dy = 1;
                setRotation(90);
            }   
        }
        else if (Greenfoot.isKeyDown("left") && !isDown)
        {
            if(checkDirection(-1, 0))
            {
                this.dx = -1;
                this.dy = 0;
                setRotation(180);
            }       
        }
        else if (Greenfoot.isKeyDown("up") && !isDown)
        {
            if(checkDirection(0, -1))
            {
                this.dx = 0;
                this.dy = -1;
                setRotation(270);
            }       
        }
        else isDown = false;
    }
            
    private boolean checkForWall(int dx, int dy)
    {
        int origX = getX();
        int origY = getY();
        int x = origX + dx * this.speed;
        int y = origY + dy * this.speed;
        
        setLocation(x, y);
        Actor wall = getOneIntersectingObject(Wall.class);
        if(null != wall)
        { 
            setLocation(x + help * dy, y + help * dx);
            wall = getOneIntersectingObject(Wall.class);
            if(null != wall)
            {
                setLocation(x - help * dy, y - help * dx);
                wall = getOneIntersectingObject(Wall.class);
                if(null != wall) setLocation(origX, origY);
            }
            return true;
        }
        else return false;
    }
        
    private void checkFood()
    {
        List <Food> food = getObjectsInRange(10,  Food.class);
        if (!food.isEmpty()) 
        {
            removeTouching(Food.class);
            Levels.levelScore++;
            Levels.overallScore++;
        }
        
        Actor powerUp = getOneObjectAtOffset(0, 0, PowerUp.class);
        if (null != powerUp) 
        {
            removeTouching(PowerUp.class);
            PowerUp.act = true;
        }        
    }
    
    private boolean checkDirection(int dx, int dy)
    {
        int x = getX();
        int y = getY();
        boolean ret = false;
        
        setLocation(x + dx * this.speed, y + dy * this.speed);
        Actor wall = getOneIntersectingObject(Wall.class);
        if(null == wall) ret = true;
        setLocation(x, y);
        return ret;
    }
    
    /*private void resetLevel()
    {
        this.dx = 1;
        this.dy = 0;
        setRotation(0);
        
        this.resetLevelCount = 0;
        this.eatImgCount = 0;
        this.eatImg = 1;
        this.delay = true;
        
        setLocation(this.startX, this.startY);
        Ghost.resetLevel = false;
    }*/
}
