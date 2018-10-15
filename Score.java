package java;

import greenfoot.*;

/**
 *
 * @author Rokas Giedraitis
 */
public class Score extends Actor{
    
    public Score()
    {
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage("Score: " + Levels.overallScore, 30, Color.BLACK, Color.YELLOW));
    }
    
}
