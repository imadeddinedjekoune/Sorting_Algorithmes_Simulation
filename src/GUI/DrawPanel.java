/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.Sort;
import Utils.Util;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Imad
 */
public class DrawPanel extends JPanel 
{
    public int Tab[] ;
    public DrawPanel()
    {
        setBackground(Color.gray);
        Tab = Util.generateRandomArray(130, 400);
        
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for ( int i = 0 ; i < Tab.length ; i++ )
        {
            if(i == Sort.i)
            {
                g.setColor(Color.green);
            }else
            {
                if(i == Sort.j)
                {
                    g.setColor(Color.red);
                }else
                {
                    g.setColor(Color.white);
                }
            }
            
            g.fillRect(1+i*6, 441-Tab[i],5, Tab[i]);
            g.setColor(Color.black);
            g.drawRect(0+i*6, 441-Tab[i],6, Tab[i]-1);
        }
    }
    
    public void rep()
    {
        this.repaint();
    }
}
