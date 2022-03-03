package paint.src.udc.psw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseMotionListener, MouseListener {

	private JLabel status;
	private int x = 0;
	private int y = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int xp = 0;
	private int yp = 0;
	private int escolheDesenho;
	private int n = 10000;
	private int[] vet_guarda_linhas = new int[n];
	private boolean desenhar = false;
	private boolean desenhar_ponto = false;
	private boolean desenhar_linha = false;

	public LinePanel(JLabel status) {
		this.status = status;
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(Color.WHITE);
	}

	public int escolhe(int escolher) {
		this.escolheDesenho = escolher;
		return this.escolheDesenho;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (escolheDesenho) {
			case 1:
				xp = e.getX();
				yp = e.getY();

				break;
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		switch (escolheDesenho) {
			case 1:
				g.fillOval(xp - 2, yp - 2, 5, 5);
				break;
			case 2:
				g.drawLine(x, y, x2, y2);
				break;
			case 3:
				g.fillOval(x - 2, y - 2, 5, 5);
				break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (escolheDesenho) {
			case 1:
				break;
			case 2:
				x = e.getX();
				y = e.getY();
				break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (escolheDesenho) {
			case 1:
				break;
			case 2:
				x2 = e.getX();
				y2 = e.getY();
				break;
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		status.setText(String.format("Movimento na posição [%d, %d]", e.getX(), e.getY()));

	}
}