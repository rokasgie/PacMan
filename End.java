package java;

import greenfoot.*;

/**
 * 
 * @author Rokas Giedraitis
 */
public class End extends World{
    
    public End()
    {
        super(StartScreen.width, StartScreen.height, 1);
        GreenfootImage img = new GreenfootImage(StartScreen.width, StartScreen.height);
        img.fill();
        setBackground(img);   
        img.drawImage(new GreenfootImage("images\\GameOver.png"), 50, 150);
        
        img.setColor(Color.YELLOW);
        img.setFont(new Font(50));
        img.drawString("Score: " + Levels.overallScore, 150, 400);
    }
    
}
