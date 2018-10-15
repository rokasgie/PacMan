package java;

/**
 *
 * @author Rokas Giedraitis
 */
public class Level2 extends Levels
{    
    public Level2()
    {
        //316
        super(200, 316);
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
        super.resetLevel(true);
    }
       
    private void createMaze()
    {
        addWalls();
         
        addRow(2, 2, 23);
        addRow(2, 5, 7);
        addRow(11, 5, 5);
        addRow(18, 5, 7);
        
        addColumn(2, 8, 4);
        addColumn(5, 8, 4);
        addColumn(6, 8, 4);
        addColumn(7, 8, 4);
        addColumn(8, 8, 4);
        addRow(11, 8, 5);
        addRow(11, 11, 5);
        addColumn(18, 8, 4);
        addColumn(19, 8, 4);
        addColumn(20, 8, 4);
        addColumn(21, 8, 4);
        addColumn(24, 8, 4);
        
        addRow(0, 14, 6);
        addRow(0, 15, 6);
        addRow(8, 14, 3);
        addRow(8, 15, 3);
        addColumn(13, 14, 2);
        addRow(16, 14, 3);
        addRow(16, 15, 3);
        addRow(21, 14, 6);
        addRow(21, 15, 6);
        
        addColumn(2, 18, 4);
        addColumn(5, 18, 4);
        addColumn(6, 18, 4);
        addColumn(7, 18, 4);
        addColumn(8, 18, 4);
        addRow(11, 18, 5);
        addRow(11, 21, 5);
        addColumn(18, 18, 4);
        addColumn(19, 18, 4);
        addColumn(20, 18, 4);
        addColumn(21, 18, 4);
        addColumn(24, 18, 4);
        
        addRow(2, 27, 23);
        addRow(2, 24, 7);
        addRow(11, 24, 5);
        addRow(18, 24, 7);
    }    
}
