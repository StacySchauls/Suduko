package cpts132.sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SudokuBoard extends javax.swing.JComponent {
  
        
    
    
    public SudokuBoard(SudokuBase b) {
        setPreferredSize(new java.awt.Dimension(b.getSize()*50, b.getSize()*50));
       
    }
    
    SudokuBase getBase() {
        return null;
    }
    
    public static void main(String[] args) {
        JPanel controls;
        SudokuBase base;
        drawBoard board;
        SelectedCell selected;
        JLabel output;
        JLabel error;
        JButton query;
        JButton set;
        JTextField txtRow;
        JTextField txtCol;
        JFrame win;
        
        
       
        
        
        
        
        
        
        
        
        
        win = new JFrame("Title");
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pnl = new JPanel();
        pnl.setBackground(Color.cyan);
        
        board = new drawBoard(3,2);
        
        pnl.add(board);
        
        win.add(pnl);
        //win.add(controls, java.awt.BorderLayout.SOUTH);
       // controls.add(pnl = new JPanel());
        SelectCell cell = new SelectCell();
        pnl.addMouseListener(cell);
        pnl.add(new JButton("Query"));
        board.add(new JButton("Button"));
        
        int column = cell.getSelectedColumn();
        int selectRow = cell.getSelectedRow();
        HighlightCell high = new HighlightCell(column, selectRow);
       
       board.add(high); 
       
        
        
        
        win.pack();
        win.setVisible(true);
        
    }
    
}
   
    
    
        
    
    
    
    
    

