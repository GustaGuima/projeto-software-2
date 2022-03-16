package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domain.Circle;
import domain.Line;
import domain.Point;
import domain.Square;


public class Window extends JFrame{
		
	DrawPanel paineldesenhar;
	 
	public Window() {
		
		super("Paint");
		
		this.setBounds(100, 100, 800, 600);
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paineldesenhar = new DrawPanel();
		paineldesenhar.setBackground(Color.WHITE);
		JMenuBar menuBar = new JMenuBar();
		JMenu figureMenu = new JMenu("Figure");
	    JMenuItem figurePoint = new JMenuItem("Point");
	    JMenuItem figureLine = new JMenuItem("Line");
	    JMenuItem figureCircle = new JMenuItem("Circle");
		JMenuItem figureSquare = new JMenuItem("Square");
	   
		this.setJMenuBar(menuBar);
		this.add(paineldesenhar, BorderLayout.CENTER);
		menuBar.add(figureMenu);
	    figureMenu.add(figurePoint);
	    figureMenu.add(figureLine);
	    figureMenu.add(figureCircle);
		figureMenu.add(figureSquare);
        
        figurePoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePoint) {
					paineldesenhar.newGeometricShape(new Point());
		      }
			}
		});
        
        figureLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureLine) {
					paineldesenhar.newGeometricShape(new Line());
				}
			}
		});
         
        
        figureCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureCircle) {
					paineldesenhar.newGeometricShape(new Circle());
				}		
			}
		}); 

		figureSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureSquare) {
					paineldesenhar.newGeometricShape(new Square());
				}		
			}
		}); 
        
		
	}
	
	
}