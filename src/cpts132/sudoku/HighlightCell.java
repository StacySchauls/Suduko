/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpts132.sudoku;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Stacy
 */
public class HighlightCell extends javax.swing.JComponent{
    private int x,y;
    public HighlightCell(int xCom, int yCom){
        this.setPreferredSize(new java.awt.Dimension(50,50));
        x = xCom;
        y = yCom;
        System.out.println("In HighlightCell");
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    @Override
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        
        System.out.println("PaintComponent!!");
        System.out.println("X: " + x + "Y: " + y);
        g.setColor(Color.red);
        g.fillRect(x, y, 49, 49);
    }
}
