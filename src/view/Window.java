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
import domain.Rectangle;
import domain.Square;

import controllers.DocumentoController;

public class Window extends JFrame {

	DrawPanel paineldesenhar;

	public Window(DocumentoController documento) {

		super("Paint");

		this.setBounds(100, 100, 900, 700);
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paineldesenhar = new DrawPanel(documento);
		paineldesenhar.setBackground(Color.WHITE);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
	    JMenuItem openFile = new JMenuItem("Open");
	    JMenuItem saveFile = new JMenuItem("Save");
	    JMenuItem exit = new JMenuItem("Exit");  
		JMenu figureMenu = new JMenu("Figure");
		JMenuItem figurePoint = new JMenuItem("Point");
		JMenuItem figureLine = new JMenuItem("Line");
		JMenuItem figureCircle = new JMenuItem("Circle");
		JMenuItem figureSquare = new JMenuItem("Square");
		JMenuItem figureRectangle = new JMenuItem("Rectangle");

		this.setJMenuBar(menuBar);
		this.add(paineldesenhar, BorderLayout.CENTER);

		menuBar.add(figureMenu);
		figureMenu.add(figurePoint);
		figureMenu.add(figureLine);
		figureMenu.add(figureCircle);
		figureMenu.add(figureSquare);
		figureMenu.add(figureRectangle);

		menuBar.add(fileMenu);
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(exit);

		figurePoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == figurePoint) {
					paineldesenhar.newGeometricShape(new Point());
				}
			}
		});

		figureLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == figureLine) {
					paineldesenhar.newGeometricShape(new Line());
				}
			}
		});

		figureCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == figureCircle) {
					paineldesenhar.newGeometricShape(new Circle());
				}
			}
		});

		figureSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == figureSquare) {
					paineldesenhar.newGeometricShape(new Square());
				}
			}
		});
		figureRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == figureRectangle) {
					paineldesenhar.newGeometricShape(new Rectangle());
				}
			}
		});

		saveFile.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == saveFile) {	
					documento.salvarFormas();
					paineldesenhar.repaint();
			 }
			}
		  });	
        
		
        newFile.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == newFile) {
					documento.novoArquivo();
					paineldesenhar.repaint();
		      }	
			}
		  });	
        
       openFile.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == openFile) {
					documento.lerFormas();
					paineldesenhar.repaint();
				}
			}
		  });	
        
        exit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == exit) {
					System.exit(0);
		      }	
			}
		  });

	}

}