package java;

/**
 *
 * @author Rokas Giedraitis
 */
public class Level3 extends Levels{
    
    public Level3()
    {
        //318
        super(300, 318);
        super.fillFood();
        Ghost.powerUpLength = 400;
        createMaze();
        super.addActors();
        
        super.x1 = 110;
        super.y1 = 120;
        super.x2 = 450;
        super.y2 = 560;
        super.x3 = 280;
        super.y3 = 400;
        super.resetLevel(true);
    }
    
    private void createMaze()
    {
        addWalls();
        
        addRow(2, 2, 6);
        addRow(10, 2, 7);
        addRow(19, 2, 6);
        addColumn(2, 3, 2);
        addColumn(7, 3, 2);
        addRow(2, 5, 2);
        addRow(6, 5, 2);
        addColumn(13, 3, 8);
        addColumn(19, 3, 2);
        addColumn(24, 3, 2);
        addRow(19, 5, 2);
        addRow(23, 5, 2);
        addColumn(10, 5, 4);
        addColumn(16, 5, 4);
        addRow(2, 8, 8);
        addRow(17, 8, 8);
        
        addRow(0, 11, 2);
        addRow(0, 12, 2);
        addRow(4, 11, 4);
        addRow(4, 12, 4);
        addColumn(7, 13, 3);
        addColumn(10, 11, 8);
        addRow(7, 18, 3);
        addColumn(13, 13, 4);
        addColumn(16, 11, 8);
        addRow(17, 18, 3);
        addColumn(19, 11, 5);
        addRow(20, 11, 3);
        addRow(20, 12, 3);
        addRow(25, 11, 2);
        addRow(25, 12, 2);
        addRow(2, 15, 3);
        addColumn(4, 16, 3);
        addRow(0, 18, 2);
        addRow(22, 15, 3);
        addColumn(22, 16, 3);
        addRow(25, 18, 2);
        
        addRow(2, 21, 9);
        addColumn(10, 22, 3);
        addColumn(13, 19, 8);
        addColumn(16, 21, 4);
        addRow(17, 21, 8);
        addRow(2, 24, 2);
        addRow(6, 24, 2);
        addColumn(2, 25, 2);
        addColumn(7, 25, 2);
        addRow(2, 27, 6);
        addRow(10, 27, 7);
        addRow(19, 24, 2);
        addRow(23, 24, 2);
        addColumn(19, 25, 2);
        addColumn(24, 25, 2);
        addRow(19, 27, 6);   
    }
}
