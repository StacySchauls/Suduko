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
public class drawBoard extends javax.swing.JComponent{
    public drawBoard(){
       this.setBorder(BorderFactory.createLineBorder(Color.black));
       
    }
    
   public void paintComponent(java.awt.Graphics g){
        //paint the backgrouns
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, 49, 49);
    }
}
