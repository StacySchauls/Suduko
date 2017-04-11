/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpts132.sudoku;

import cpts132.test.sudoku.SymbolRendererTest;
import java.awt.Color;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class to render symbols
 * @author Stacy
 */
public class PrimarySymbols implements SymbolRenderer {

    @Override
    public void drawSymbol(java.awt.Graphics g, int x, int y, int value) {
        
        if(value<0 || value > 12){
            return;
        }
       Graphics2D g2 = (Graphics2D) g;
       g2.setStroke(new BasicStroke(5));
       //switch statement to know which symbol to draw
       switch (value){
            case 0:
                //square
                g.fillRect(x, y, 40, 40);
                g.setColor(Color.white);
                g.fillRect(x+5,y+5,30,30);
               break;
               
            case 1:
                //circle
                g.fillOval(x, y, 40, 40);
                g.setColor(Color.white);
                g.fillOval(x+5, y+5, 30,30);
                break;
                
            case 2: 
                //left arc
                g.fillArc(x-20, y, 40, 40, -90, 180);
                //right arc
                g.fillArc(x+20, y, 40, 40, 90, 180);

                //left middle arc
                g.setColor(Color.white);
                g.fillArc(x-15, y+5, 30, 30, -90, 180);
                //right middle arc
                g.fillArc(x+25, y+5, 30, 30, 90, 180);
               break;
               
            case 3:
                System.out.println("DRAW SYMBOL");
                // X
                g2.draw(new Line2D.Float(x, y, x+40, y+40));
                g2.draw(new Line2D.Float(x+40, y, x, y+40));
                break;
                
            case 4: 
               //+
                g2.draw(new Line2D.Float(x+20, y, x+20, y+40));
                g2.draw(new Line2D.Float(x, y+20, x+40, y+20));
               break;
               
            case 5:
                //arrow
                g2.draw(new Line2D.Float(x, y+40, x+40, y+40));
                g2.draw(new Line2D.Float(x, y, x+40, y));
                g2.draw(new Line2D.Float(x, y, x+40, y));
                g2.draw(new Line2D.Float(x+20, y, x+20, y+40));
                break;
                
            case 6:
              // I
                g2.draw(new Line2D.Float(x, y, x, y+40));
                g2.draw(new Line2D.Float(x+40, y, x+40, y+40));
                g2.draw(new Line2D.Float(x, y+20, x+40, y+20));
               break;
               
            case 7:
                // Triangle
                g2.draw(new Line2D.Float(x+20, y, x, y+40));
                g2.draw(new Line2D.Float(x, y+40, x+40, y+40));
                g2.draw(new Line2D.Float(x+20, y, x+40, y+40));
                break;
                
            case 8: 
                // H
                g2.draw(new Line2D.Float(x, y+40, x+40, y));
                g2.draw(new Line2D.Float(x, y, x+40, y));
                g2.draw(new Line2D.Float(x+40, y, x+40, y+40));
               break;
               
            case 9:
                //X's with dots
                g2.draw(new Line2D.Float(x, y, x+40, y+40));
                g2.draw(new Line2D.Float(x+40, y, x, y+40));
                g2.draw(new Line2D.Float(x, y+20, x, y+20));
                g2.draw(new Line2D.Float(x+20, y, x+20, y));
                g2.draw(new Line2D.Float(x+40, y+20, x+40, y+20));
                g2.draw(new Line2D.Float(x+20, y+40, x+20, y+40));
                break;
                
            case 10: 
                //B thing
                g2.draw(new Line2D.Float(x, y, x, y+40));
                g2.draw(new Line2D.Float(x, y, x+20, y));
                g2.draw(new Line2D.Float(x+20, y, x+10, y+20));
                g2.draw(new Line2D.Float(x+10, y+20, x+20, y+40));
                g2.draw(new Line2D.Float(x+20, y+40, x, y+40));
               break;
               
            case 11:
                //Cresant moon thing
                g2.fillArc(x, y, 40, 40, 90, 180);
                g2.setColor(Color.white);
                g2.fillArc(x+5, y, 30, 30, 90, 180);
                break;
             
            case 12:
                //Double triangle things
                int xpoints[] = {x,x,x+20,x+40,x+40};
                int ypoints[] = {y,y+40,y+20,y,y+40};
                int npoints = 5;
                g2.drawPolygon(xpoints, ypoints, npoints);
                break;     
       }
      
    }

    
    public static void main(String[] arhgs){
        new SymbolRendererTest().testSymbols(new PrimarySymbols());
    }
}
