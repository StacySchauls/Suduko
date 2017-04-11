/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpts132.sudoku;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Stacy
 */
public class SudokuView extends SudokuBoard{
    private SudokuBase base;
    private SymbolRenderer r;
    
    public SudokuView(SudokuBase b) {
        super(b);
        SudokuBoard board = new SudokuBoard(b);
        base = b;
        r = new PrimarySymbols();
        
    }

    @Override
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);     
        r.drawSymbol(g, 45, 45, 3);
    }
   
}
