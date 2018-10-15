package java;

import greenfoot.*;

/**
 * 
 * @author Rokas Giedraitis
 */
public class PowerUp extends Actor{
    
    public static boolean act = false;
    
    public PowerUp()
    {
        PowerUp.act = false;
        setImage(new GreenfootImage("images\\PowerUp.png"));   
    }
}
