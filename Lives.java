package java;

import greenfoot.*;

/**
 *
 * @author Rokas Giedraitis
 */
public class Lives extends Actor{
    
    public Lives()
    {
        update();  
    }

    public void update()
    {
        setImage(new GreenfootImage("Lives: " + PacMan.lives, 30, Color.BLACK, Color.YELLOW));
    } 
        
}
