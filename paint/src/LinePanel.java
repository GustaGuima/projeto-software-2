

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseMotionListener, MouseListener {

	private JLabel status;
	public int xp, yp, x, y, x1, x2, y1, y2, r, w, h, xDist, yDist;
	public static boolean flag = false, pressFlag = false;
	private int escolheDesenho;
	private int n = 10000;
	private int[] vet_guarda_linhas = new int[n];

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
				super.paintComponent(g);
				g.drawOval(x1, y1, x2 - x1, y2 - y1);
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
			case 3:
				x1 = y1 = 0;
				r = x2 = y2 = 0;
				x1 = e.getX();
				y1 = e.getY();
				break;
		}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (escolheDesenho) {
			case 3:
				w = x2 - x;
				h = y2 - y;
				r = (int) Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
				break;
		}
		repaint();
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
			case 3:
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