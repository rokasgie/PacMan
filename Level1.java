package java;

/**
 * 
 * @author Rokas Giedraitis
 */
public class Level1 extends Levels
{         
    public Level1()
    {
        //max = 318
        super(100, 318);
        super.fillFood();
        Ghost.powerUpLength = 500;
        createMaze();
        super.addActors();
        
        super.x1 = 30;
        super.y1 = 60;
        super.x2 = 530;
        super.y2 = 620;
        super.x3 = 280;
        super.y3 = 380;
        super.resetLevel(false);
    } 
        
    private void createMaze()
    {
        addWalls();
        
        addRow(2, 2, 3);
        addRow(7, 2, 4);
        addColumn(13, 0, 4);
        addRow(16, 2, 4);
        addRow(22, 2, 3);
        addRow(2, 3, 3);
        addRow(7, 3, 4);
        addRow(16, 3, 4);
        addRow(22, 3, 3);
        //**********************************************************************
        addRow(2, 6, 3);  
        addColumn(7, 6, 7);
        addRow(10, 6, 7);
        addColumn(19, 6, 7);
        addRow(22, 6, 3);
        addColumn(13, 7, 3);
        addRow(8, 9, 3);
        addRow(16, 9, 3);
        //**********************************************************************
        //Blokai
        addRow(2, 9, 3);
        addColumn(2, 10, 2);
        addColumn(4, 10, 2);
        addRow(2, 12, 3);
        
        addRow(2, 15, 3);
        addColumn(2, 16, 2);
        addColumn(4, 16, 2);
        addRow(2, 18, 3);
        
        addRow(22, 9, 3);
        addColumn(22, 10, 2);
        addColumn(24, 10, 2);
        addRow(22, 12, 3);
        
        addRow(22, 15, 3);
        addColumn(22, 16, 2);
        addColumn(24, 16, 2);
        addRow(22, 18, 3);       
        //**********************************************************************
        //Centras
        
        addRow(11, 12, 5);
        addColumn(10, 12, 4);
        addColumn(12, 13, 2);
        addColumn(14, 13, 2);
        addColumn(16, 12, 4);
        addRow(11, 15, 5);
        
        //**********************************************************************
        addColumn(7, 15, 4);
        addColumn(19, 15, 4);
        addRow(10, 18, 7);
        addColumn(13, 19, 3);
        addRow(2, 21, 3);
        addRow(7, 21, 4);
        addRow(16, 21, 4);
        addRow(22, 21, 3);
        addColumn(4, 22, 3);
        addColumn(22, 22, 3);
        //**********************************************************************
        addRow(0, 24, 2);
        addRow(10, 24, 7);
        addRow(25, 24, 2);
        addColumn(7, 24, 3);
        addColumn(13, 25, 3);
        addColumn(19, 24, 3);
        addRow(2, 27, 9);
        addRow(16, 27, 9); 
    } 
}
