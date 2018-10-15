package java;

import greenfoot.*;

/**
 * 
 * @author Rokas Giedraitis
 */
public class Victory extends World{
    
    public Victory()
    {
        super(StartScreen.width, StartScreen.height, 1);
        GreenfootImage img = new GreenfootImage(StartScreen.width, StartScreen.height);
        img.fill();
        setBackground(img);
        
        GreenfootImage vic = new GreenfootImage("images\\Victory.png");
        img.drawImage(vic, 125, 200);
        
        img.setColor(Color.YELLOW);
        img.setFont(new Font(50));
        img.drawString("Score: " + Levels.overallScore, 175, 400);
        
    }
    
}
