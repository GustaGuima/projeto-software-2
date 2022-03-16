package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import javax.swing.JPanel;

import domain.Circle;
import interfaces.GeometricShape;
import interfaces.Panel;
import interfaces.Shape;
import domain.Line;
import domain.Point;
import domain.Square;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, Panel {
	private GeometricShape newShape;
	Shape controller;

	public DrawPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		GeometricShape shape = newShape;
		if (newShape != null) {
			shape.getController().paint(g);
		}
	}

	public void mouseClicked(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto1(new Point(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setA(new Point(event.getPoint().x, event.getPoint().y));
				c.setB(new Point(event.getPoint().x, event.getPoint().y));
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setA(new Point(event.getPoint().x, event.getPoint().y));
				s.setB(new Point(event.getPoint().x, event.getPoint().y));
			}
		}
	}

	public void mousePressed(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				reload();
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto1(new Point(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setA(new Point(event.getPoint().x, event.getPoint().y));
				c.setB(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setA(new Point(event.getPoint().x, event.getPoint().y));
				s.setB(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			}
		}

	}

	public void mouseReleased(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setB(new Point(event.getPoint().x, event.getPoint().y));
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setB(new Point(event.getPoint().x, event.getPoint().y));
			}
		}

	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseDragged(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				reload();
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setB(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setB(new Point(event.getPoint().x, event.getPoint().y));

				reload();
			}
		}
	}

	public void mouseMoved(MouseEvent event) {
	}

	@Override
	public void newGeometricShape(GeometricShape shape) {
		this.newShape = shape;
		this.controller = shape.getController();
	}

	@Override
	public void reload() {
		repaint();
	}
}
