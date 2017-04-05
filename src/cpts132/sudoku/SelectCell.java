
package cpts132.sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Stacy
 */
public class SelectCell implements SelectedCell, MouseListener{

    private int x = 0;
    private int y = 0;
    @Override
    public void setSelected(int row, int col) {
        
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
        System.out.println("X: " + x + "Y: " +y);
        System.out.println("Pressed");
        this.getSelectedRow();
        this.getSelectedColumn();
        
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
