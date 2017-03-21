package cpts132.test.sudoku;

public class SudokuModelTest {
    
    public static void randomTest(int rows, int cols) {
        
        // create a board of the given layout
        cpts132.sudoku.SudokuModel model = new cpts132.sudoku.SudokuModel(rows, cols);
        int size = model.getSize();
        
        // put random values into the board
        for(int i = 0; i < size * size; i++) {
            int row = (int)(Math.random() * size);
            int col = (int)(Math.random() * size);
            int value = (int)(Math.random() * (size + 1));
            model.setValue(row, col, value);
        }
        
        // print out the board
        System.out.println("Random board: " + rows + "x" + cols);
        System.out.println(model);
        /*
        // report state
        for(int i = 0; i < size; i++)
            System.out.println("Row " + i + " state: " + model.getRowState(i));
        for(int i = 0; i < size; i++)
            System.out.println("Column " + i + " state: " + model.getColumnState(i));
*/
        for(int i = 0; i < 1; i++)
            System.out.println("Region " + i + " state: " + model.getRegionState(i));
        System.out.println();
        
    }
    
    public static void main(String[] args) {
        //randomTest(2,2);
        randomTest(2,3);
       // randomTest(3,3);
    }
}
