package cpts132.sudoku;

public abstract class SudokuBase extends java.util.Observable {
    
    private final int rows;
    private final int columns;
    private final int size;
    
    public enum State {COMPLETE, INCOMPLETE, ERROR};
    
    /**
     * Constructor for the Sudoku base
     * @param layoutRows the number of rows for the board
     * @param layoutColumns the number of columns for the board
     */
    public SudokuBase(int layoutRows, int layoutColumns) {
        rows = layoutRows;
        columns = layoutColumns;
        size = columns * rows;
       
    }
    
    /**
     * method to get the number of rows in the board
     * @return the number of rows in the board
     */
    public int getRows() {
        return rows;
    }
    
    /**
     * method to return the number of columns in the board
     * @return the number of columns in the board
     */
    public int getColumns() {
        return columns;
    }
    
    /**
     * method to return the size of the board
     * @return the size of the board
     */
    public int getSize() {
        return size;
    }
   
    
    public abstract int getValue(int row, int col);
    
    public abstract void setValue(int row, int col, int value);
    
    public abstract boolean isGiven(int row, int col);
    
    public abstract void fixGivens();
    
    public abstract State getRowState(int n);
    
    public abstract State getColumnState(int n);
    
    public abstract State getRegionState(int n);
    
}
