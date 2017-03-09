package cpts132.sudoku;


import java.awt.Color;
import javax.swing.BorderFactory;


public class SudokuBoard extends javax.swing.JComponent {
  //the dimensions of the board
    private int rows;
    private int cols;
    private int size;
    
    /**
     * constructor for the class. sets up the rows, columns and size
     * @param b the sudoku base
     */
    public SudokuBoard(SudokuBase b) {
      setPreferredSize(new java.awt.Dimension(b.getSize()*50, b.getSize()*50));
      this.setBorder(BorderFactory.createLineBorder(Color.black));
      rows = b.getRows();
      cols = b.getColumns();
      size = b.getSize();

    }
    
    SudokuBase getBase() {
        return null;
    }
    
    public static void main(String[] args) {
        
 
        new SudokuBoardTest(2,3);
        
   
    }
 
   
    @Override
    /**
     * Paint component of JComponent, draws the Sudoku board
     * @param g the graphics object
     */
   public void paintComponent(java.awt.Graphics g){
       super.paintComponent(g);
       System.out.println("Cols: " + cols +" Rows: "+rows +" Size: "+size);
       g.setColor(Color.black);
       for(int k= 0; k<size; k++){
            for(int i = 0; i<size; i++){
                    g.setColor(Color.white);
                    g.fillRect(i*50, k*50, 49, 49);
                    g.setColor(Color.black);
                    g.drawRect(i*50, k*50, 49, 49);

            }
       }
       
       
     }
    
}
   
    
    
        
    
    
    
    
    

