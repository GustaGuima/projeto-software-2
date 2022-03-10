package pacote;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* import connection.ConexaoMySQL; */
/* import dao.DesenhoDAO; */
import formas.Circulo;
import formas.Linha;
import formas.Ponto;


public class MeuFrame extends JFrame{
		
	PainelDesenhar paineldesenhar;
	 
	public MeuFrame() {
		
		super("Trabalho PSW II");
		
		this.setSize(800,600);
		this.setLocation(450,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		paineldesenhar = new PainelDesenhar(status);
		JMenuBar menuBar = new JMenuBar();
		JMenu figureMenu = new JMenu("Figure");
	    JMenuItem figurePonto = new JMenuItem("Ponto");
	    JMenuItem figureLinha = new JMenuItem("Linha");
	    JMenuItem figureCircle = new JMenuItem("Circulo");
	   
		this.add(status, BorderLayout.SOUTH);
		this.add(paineldesenhar, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		menuBar.add(figureMenu);
	    figureMenu.add(figurePonto);
	    figureMenu.add(figureLinha);
	    figureMenu.add(figureCircle);
        
        figurePonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePonto) {
					paineldesenhar.novaFormaGeometrica(new Ponto());
		      }
			}
		});
        
        figureLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureLinha) {
					paineldesenhar.novaFormaGeometrica(new Linha());
				}
			}
		});
         
        
        figureCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureCircle) {
					paineldesenhar.novaFormaGeometrica(new Circulo());
				}		
			}
		}); 
        
		
	}
	
	
}