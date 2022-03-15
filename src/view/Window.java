package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domain.Circle;
import domain.Line;
import domain.Point;


public class Window extends JFrame{
		
	DrawPanel paineldesenhar;
	 
	public Window() {
		
		super("Paint");
		
		this.setBounds(100, 100, 800, 600);
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paineldesenhar = new DrawPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu figureMenu = new JMenu("Figuras");
	    JMenuItem figurePonto = new JMenuItem("Ponto");
	    JMenuItem figureLinha = new JMenuItem("Linha");
	    JMenuItem figureCircle = new JMenuItem("Circulo");
	   
		this.setJMenuBar(menuBar);
		this.add(paineldesenhar, BorderLayout.CENTER);
		menuBar.add(figureMenu);
	    figureMenu.add(figurePonto);
	    figureMenu.add(figureLinha);
	    figureMenu.add(figureCircle);
        
        figurePonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePonto) {
					paineldesenhar.newGeometricShape(new Point());
		      }
			}
		});
        
        figureLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureLinha) {
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
        
		
	}
	
	
}