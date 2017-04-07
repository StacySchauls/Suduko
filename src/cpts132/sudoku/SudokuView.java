/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpts132.sudoku;

import java.awt.Graphics;

/**
 *
 * @author Stacy
 */
public class SudokuView extends SudokuBoard{
    
    public SudokuView(SudokuBase b) {
        super(b);
        SudokuBoard board = new SudokuBoard(b);
    }

    
    
}
