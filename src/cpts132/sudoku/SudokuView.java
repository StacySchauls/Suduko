package cpts132.sudoku;
import java.awt.Color;
/**
 *
 * @author Stacy
 */
public class SudokuView extends SudokuBoard{
    private SudokuBase base;
    private SymbolRenderer r;
    
    /**
     * Constructor for the SudokuView class
     * @param b the SudokuBase
     */
    public SudokuView(SudokuBase b) {
        super(b);
        SudokuBoard board = new SudokuBoard(b);
        base = b;
        r = new PrimarySymbols();
    }

    @Override
    /**
     * The paint component to render the images
     * @param g, the graphics component 
     */
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black); 
        for(int i = 0; i < base.getSize(); i++){
            for(int j = 0; j < base.getSize(); j++)
            r.drawSymbol(g, 5 + i*50, 5 + j*50, base.getValue(i, j));
            g.setColor(Color.black); 
        }
        
    }
   
}
