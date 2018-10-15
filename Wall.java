package java;

import greenfoot.*;
import java.util.List;

/**
 * 
 * @author Rokas Giedraitis
 */
public class Wall extends Actor
{
    public static final int krastine  = 20;
    
    public Wall()
    {
        GreenfootImage img = new GreenfootImage(krastine, krastine);
        img.setColor(new Color(0, 0, 180));
        img.fill();
        setImage(img);
    }
    
    public Wall(double plotis, double aukstis)
    {
        int y = (int)(krastine * aukstis);
        int x = (int)(krastine * plotis);
                
        GreenfootImage img = new GreenfootImage(x, y);
        img.setColor(Color.BLUE);
        img.fill();
        setImage(img);    
    }
    
    @Override
    protected void addedToWorld(World Levels)
    {
        List<Food> food = getIntersectingObjects(Food.class);
        if (!food.isEmpty()) {
            for (int i = 0; i < food.size(); i++) {
                removeTouching(Food.class);
            }
        }
    }
}
