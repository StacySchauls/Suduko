package cpts132.sudoku;

public class SudokuBoard extends javax.swing.JComponent {
    
    public SudokuBoard(SudokuBase b) {
    }
    
    SudokuBase getBase() {
        return null;
    }
    
    public static void main(String[] args) {
        javax.swing.JFrame win = new javax.swing.JFrame("Test 2x3");
        win.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        win.add(new SudokuBoard(new SudokuStub(2, 3)));
        win.pack();
        win.setVisible(true);
    }
    
}
