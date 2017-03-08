/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpts132.sudoku;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 *
 * @author Stacy
 */
public class drawBoard extends javax.swing.JComponent{
 
    private int rows;
    private int cols;
    private int size;
    int counter = 0;
    private Color gray = new Color(220,220,220);
    
    public drawBoard(int row, int col){
      this.setBorder(BorderFactory.createLineBorder(Color.black));
      setPreferredSize(new java.awt.Dimension(col*row*50, col*row*50));
      
      
      System.out.println(col +" : " + row);
      
      rows = row;
      cols = col;
      size = row*col;
    }
    
    @Override
   public void paintComponent(java.awt.Graphics g){
       super.paintComponent(g);
       System.out.println("Cols: " + cols +" Rows: "+rows +" Size: "+size);
       g.setColor(Color.black);
       for(int k= 0; k<size; k++){
            for(int i = 0; i<size; i++){
               
                    
                    g.setColor(Color.white);
                    g.fillRect(i*50, k*50, 49, 49);
                    
                
                    //g.setColor(Color.red);
                    //g.fillRect(i*50, k*50, 49, 49);
                

                    g.setColor(Color.black);
                    g.drawRect(i*50, k*50, 49, 49);

            }
       }
       
       
     }
           
      
   }
   

