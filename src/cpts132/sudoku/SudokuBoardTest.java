package cpts132.sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class to create a test board for the Sudoku board
 * @author Stacy Schauls
 * @version Minimal
 */
public class SudokuBoardTest {
    //Fields
        JFrame win;
        JPanel controls;
        SudokuBase base;
        SudokuBoard board;
        SelectedCell selected;
        JLabel output;
        JLabel error;
        JButton query;
        JButton set;
        JTextField txtRow;
        JTextField txtCol;
        
    /**
     * The method to create different instances regarding the board
     * @param row the number of rows for the board
     * @param col the number of columns for the board
     */
    public SudokuBoardTest(int row, int col) {
        //create the title for the board
        String title = row + "x" + col + " Board";
        //create the window
        win = new JFrame(title);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //create the base using the SudokuStub
        base = new SudokuStub(row, col);
        //create the board from the base
        board = new SudokuBoard(base);
        //create a panel to  put the board on
        JPanel pnl = new JPanel();
        pnl.add(board);
        pnl.setBackground(java.awt.Color.cyan);
        win.add(pnl);
        //create a new panel for the board
        controls = new JPanel();
        win.add(controls, java.awt.BorderLayout.SOUTH);
        pnl = new JPanel();
        controls.add(pnl);
        output = new JLabel();
        if(board instanceof SelectedCell) {
            selected = (SelectedCell) board;
            pnl.add(query = new JButton("Query"));
            pnl.add(output);
            query.addMouseListener(board);
            //query.addActionListener((ActionListener) this);
            controls.add(pnl = new JPanel());
            pnl.add(new JLabel("row:"));
            pnl.add(txtRow = new JTextField(2));
            pnl.add(new JLabel("col:"));
            pnl.add(txtCol = new JTextField(2));
            pnl.add(set = new JButton("Set"));
            pnl.add(error = new JLabel());
            error.setForeground(java.awt.Color.red);
            set.addMouseListener(board);
           // set.addActionListener((ActionListener) this);
            controls.setLayout(new java.awt.GridLayout(2, 1));
        } else {
            pnl.add(output);
            output.setText("SelectedCell not supported");
        }
        win.setVisible(true);
        win.pack();
    }
    
    /**
     * The actionlistener method for the class, used for the selected cell
     * @param e the action event
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == query) {
            output.setText("Selected cell: " +
                           selected.getSelectedRow() + ", " +
                           selected.getSelectedColumn());
            error.setText("");
        } else if(e.getSource() == set) {
            output.setText("");
            try {
                int row = Integer.parseInt(txtRow.getText());
                int col = Integer.parseInt(txtCol.getText());
                selected.setSelected(row, col);
                error.setText("");
            } catch(NumberFormatException ex) {
                error.setText("Non-integer input: " + ex.getMessage());
            } catch(IllegalArgumentException ex) {
                error.setText("Error: " + ex.getMessage());
            }
        }
        win.pack();
    }
    }
    

