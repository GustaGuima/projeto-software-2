package pacote;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.FormaGeometrica;
import manipuladores.ManipuladorForma;

public class PainelDesenhar extends JPanel implements MouseListener, MouseMotionListener, OuvintePaineis {
	private JLabel status;


	private FormaGeometrica novaForma;
	ManipuladorForma manipulador;
	
	public PainelDesenhar(JLabel status) {
		this.status = status;

		this.novaForma = new Ponto();

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa a �rea de desenho
		FormaGeometrica forma = novaForma;
		forma.getManipulador().paint(g);
	}


	public void mouseClicked(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto1(new Ponto(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
			}
		}
	}

	// trata evento quando mouse � pressionado
	public void mousePressed(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				atualizar();
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto1(new Ponto(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}
		}

	}

	public void mouseReleased(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
				

				novaForma = null;
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));
				

				novaForma = null;
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				novaForma = null;
			} 
		}
		
	}


	public void mouseEntered(MouseEvent event) {
		
		// setBackground( Color.GREEN );
	}


	public void mouseExited(MouseEvent event) {
	}
		


	public void mouseDragged(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				atualizar();
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}
		}
	}


	public void mouseMoved(MouseEvent event) {
			}

	@Override
	public void novaFormaGeometrica(FormaGeometrica forma) {
		this.novaForma = forma;
		this.manipulador = forma.getManipulador();
	}

	@Override
	public void atualizar() {
		repaint();
	}
}
