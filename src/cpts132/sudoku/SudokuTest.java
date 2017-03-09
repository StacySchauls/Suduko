package cpts132.sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Stacy
 */
public class SudokuTest implements ActionListener{

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
        
    public SudokuTest(int row, int col) {
        String title = row + "x" + col + " Board";
        win = new JFrame(title);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        base = new SudokuStub(row, col);
        board = new SudokuBoard(base);
        JPanel pnl = new JPanel();
        pnl.add(board);
        pnl.setBackground(Color.cyan);
        win.add(pnl);
        controls = new JPanel();
        win.add(controls, BorderLayout.SOUTH);
        pnl = new JPanel();
        controls.add(pnl);
        output = new JLabel();
        if(board instanceof SelectedCell) {
            selected = (SelectedCell) board;
            pnl.add(query = new JButton("Query"));
            pnl.add(output);
            query.addActionListener(this);
            controls.add(pnl = new JPanel());
            pnl.add(new JLabel("row:"));
            pnl.add(txtRow = new JTextField(2));
            pnl.add(new JLabel("col:"));
            pnl.add(txtCol = new JTextField(2));
            pnl.add(set = new JButton("Set"));
            pnl.add(error = new JLabel());
            error.setForeground(java.awt.Color.red);
            set.addActionListener(this);
            controls.setLayout(new java.awt.GridLayout(2, 1));
        } else {
            pnl.add(output);
            output.setText("SelectedCell not supported");
        }
        win.setVisible(true);
        win.pack();
        
        
        
    }

    @Override
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
    
   
       
    
    

