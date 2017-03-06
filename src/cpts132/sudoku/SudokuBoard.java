package cpts132.sudoku;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

public class SudokuBoard extends javax.swing.JComponent {
  
    private Color c = new Color(220,220,220);
    
    private int size =0;
    private int rows = 0;
    private int col = 0;
    public SudokuBoard(SudokuBase b) {
        setPreferredSize(new java.awt.Dimension(b.getSize()*50, b.getSize()*50));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        System.out.println(b.getSize());
        size = b.getSize();
        rows = b.getRows();
        col = b.getColumns();  
    }
    
    SudokuBase getBase() {
        return null;
    }
    
    public static void main(String[] args) {
        
        javax.swing.JFrame win = new javax.swing.JFrame("Test 2x3");
        win.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        JComponent c = new SudokuBoard(new SudokuStub(2,3));
        GridLayout grid = new GridLayout(6,6,2,2);
        win.add(c);
        c.setLayout(grid);
       
        
       // c.setBorder(new EmptyBorder(2,2,2,2));
       
        
        for(int i =0; i <36; i++){
            c.add(new drawBoard());
        }
         
        
        // win.add(new SudokuBoard(new SudokuStub(4, 3)));
        win.pack();
        win.setVisible(true);
    }
    
    
   /* public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
         g.setColor(Color.BLACK);
        
        for(int i=0; i<col; i++){
            for(int j = 0; j<rows; j++){
                g.drawRect(50*i, 50*j, 50, 50);
            }
        }

        
       
        
        }
//        g.setColor(Color.BLACK);
//        g.drawRect(2, 2, 50, 50);
//        
//        g.setColor(c);
//        //g.fillRect(2, 2, 50, 50);
        
*/
        
    }
    
    
    
    

