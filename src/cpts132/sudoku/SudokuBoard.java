package cpts132.sudoku;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;



public class SudokuBoard extends javax.swing.JComponent implements SelectedCell, MouseListener{
  //the dimensions of the board
    private int rows;
    private int cols;
    private int size;
    private int x = 0;
    private int y = 0;

    
    /**
     * constructor for the class. sets up the rows, columns and size
     * @param b the Sudoku base
     */
    public SudokuBoard(SudokuBase b) {
      
      setPreferredSize(new java.awt.Dimension(b.getSize()*50, b.getSize()*50));
      this.setBorder(BorderFactory.createLineBorder(Color.black));
      this.addMouseListener(this);
      rows = b.getRows();
      cols = b.getColumns();
      size = b.getSize();

      
    }
    
    SudokuBase getBase() {
        return null;
    }
    
    public static void main(String[] args){
        
 
        new SudokuBoardTest(3,3);
        
   
    }
 
   
    @Override
    /**
     * Paint component of JComponent, draws the Sudoku board
     * @param g the graphics object
     */
   public void paintComponent(java.awt.Graphics g){
       super.paintComponent(g);
       //System.out.println("Cols: " + cols +" Rows: "+rows +" Size: "+size);
       g.setColor(Color.black);
       for(int k= 0; k<size; k++){
            for(int i = 0; i<size; i++){
                    g.setColor(Color.white);
                    g.fillRect(i*50, k*50, 49, 49);
                    g.setColor(Color.black);
                    g.drawRect(i*50, k*50, 49, 49);
            }
       }
       g.setColor(Color.black);
       g.drawRect((x/50)*50, (y/50)*50, 49, 49);
       g.setColor(Color.YELLOW);
       g.fillRect( (x/50)*50, (y/50)*50, 49, 49);  
     }
   
   

    @Override
     public void setSelected(int row, int col) {
        x = 50*col;
        y = 50*row;
        repaint();
    }

    @Override
    public int getSelectedRow() {
        System.out.println("Row: "+ (y/50));
        return y/50;
    }

    @Override
    public int getSelectedColumn() {
        System.out.println("Column: "+ (x/50));
        return x/50;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e){
         x = e.getX();
         y = e.getY();
        repaint();
    }

 

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

  

    
    
}
   
    
    
        
    
    
    
    
    

