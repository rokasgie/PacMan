package java;

import greenfoot.*;

/**
 *
 * @author Rokas Giedraitis
 */
public class StartScreen extends World {
    
    public static final int border = 30;
    public static final int width = 560;
    public static  final int height = 620 + border;    
    public StartScreen()
    {
        super(StartScreen.width, StartScreen.height, 1);
        GreenfootImage img = new GreenfootImage(StartScreen.width, StartScreen.height);
        img.fill();
        setBackground(img);   
        img.drawImage(new GreenfootImage("images\\Pac-Man.png"), 30, 200); 
        Greenfoot.setSpeed(48);    
   }
    
    @Override
    public void act()
    {
        Greenfoot.setWorld(new Levels());
        
    }
}
