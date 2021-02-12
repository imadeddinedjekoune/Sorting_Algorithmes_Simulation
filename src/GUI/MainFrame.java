/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.Sort;
import Utils.Util;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Imad
 */
public class MainFrame extends JFrame {
    private static int width = 797 , height = 503  ;
    
    public static DrawPanel p ;
    private JMenuBar mb = new JMenuBar();
    private JMenu m_operation = new JMenu("Operation");
    private JMenu m_sort = new JMenu("Sort");
    
    private JMenuItem i1 = new JMenuItem("Scrable");
    private JMenuItem i2 = new JMenuItem("Selection Sort");
    private JMenuItem i3 = new JMenuItem("Bubble Sort");
    private JMenuItem i4 = new JMenuItem("Insertion Sort");
    private JMenuItem i5 = new JMenuItem("Merge Sort");
    
    
        
    public MainFrame()
    {
        mb.add(m_operation);
        mb.add(m_sort);
        
        m_operation.add(i1);
        
        m_sort.add(i2);
        m_sort.add(i3);
        m_sort.add(i4);
        m_sort.add(i5);
        
        
        
        p = new DrawPanel();
        setTitle("Sorting Algorithmes Simulation");
	//setResizable(false);
        setSize(width,height);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-width)/2,
                    (Toolkit.getDefaultToolkit().getScreenSize().height-height)/2);
        
        listener();
        
        setLayout(new BorderLayout());
        add(p , BorderLayout.CENTER);
        add(mb , BorderLayout.NORTH);
    }
    
    private void listener()
    {
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.Tab = Util.generateRandomArray(130, 400);
                p.rep();
            }
        });
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t1 = new Thread(() -> {
                    Sort.MySort(p.Tab);
                });
                t1.start();
                Thread t2 = new Thread(() -> {
                    while(t1.isAlive())
                       p.rep();
                });
                t2.start();
            }
        });
        
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t1 = new Thread(() -> {
                    Sort.bubbleSort(p.Tab);
                });
                t1.start();
                Thread t2 = new Thread(() -> {
                    while(t1.isAlive())
                       p.rep();
                });
                t2.start();
            }
        });
        
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t1 = new Thread(() -> {
                    Sort.insertionSort(p.Tab);
                });
                t1.start();
                Thread t2 = new Thread(() -> {
                    while(t1.isAlive())
                       p.rep();
                });
                t2.start();
            }
        });
        
        i5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t1 = new Thread(() -> {
                    Sort.mergeSort(p.Tab,0,p.Tab.length-1);
                });
                t1.start();
                Thread t2 = new Thread(() -> {
                    while(t1.isAlive())
                       p.rep();
                });
                t2.start();
            }
        });
    }
}
