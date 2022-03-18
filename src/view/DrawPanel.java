package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import javax.swing.JPanel;

import controllers.DocumentoController;
import domain.Circle;
import interfaces.GeometricShape;
import interfaces.Panel;
import interfaces.Shape;
import interfaces.Lista;
import domain.Line;
import domain.Point;
import domain.Rectangle;
import domain.Square;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, Panel {
	private GeometricShape newShape;
	Shape controller;

	DocumentoController documento;

	public DrawPanel(DocumentoController documento) {
		this.documento = documento;
		newGeometricShape(new Point());
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Lista<GeometricShape> it = documento.getIterador();
		GeometricShape shape = newShape;

		newShape.getController().paint(g);
		while ((shape = it.proximo()) != null) {
			shape.getController().paint(g);
			reload();
		}
	}

	public void mouseClicked(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
				documento.inserirFim(newShape);

				newGeometricShape(new Point());
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto1(new Point(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Line());
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setA(new Point(event.getPoint().x, event.getPoint().y));
				c.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Circle());
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setA(new Point(event.getPoint().x, event.getPoint().y));
				s.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Square());
			} else if (newShape.getClass().equals(Rectangle.class)) {
				Rectangle r = (Rectangle) newShape;
				r.setA(new Point(event.getPoint().x, event.getPoint().y));
				r.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Rectangle());
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
			} else if (newShape.getClass().equals(Rectangle.class)) {
				Rectangle r = (Rectangle) newShape;
				r.setA(new Point(event.getPoint().x, event.getPoint().y));
				r.setB(new Point(event.getPoint().x, event.getPoint().y));
			}
		}

	}

	public void mouseReleased(MouseEvent event) {
		if (newShape != null) {
			if (newShape.getClass().equals(Point.class)) {
				Point p = (Point) newShape;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
				documento.inserirFim(newShape);

				newGeometricShape(new Point());
				reload();
			} else if (newShape.getClass().equals(Line.class)) {
				Line l = (Line) newShape;
				l.setPonto2(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Line());
				reload();
			} else if (newShape.getClass().equals(Circle.class)) {
				Circle c = (Circle) newShape;
				c.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Circle());
				reload();
			} else if (newShape.getClass().equals(Square.class)) {
				Square s = (Square) newShape;
				s.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Square());
				reload();
			} else if (newShape.getClass().equals(Rectangle.class)) {
				Rectangle r = (Rectangle) newShape;
				r.setB(new Point(event.getPoint().x, event.getPoint().y));
				documento.inserirFim(newShape);

				newGeometricShape(new Rectangle());
				reload();
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
			} else if (newShape.getClass().equals(Rectangle.class)) {
				Rectangle r = (Rectangle) newShape;
				r.setB(new Point(event.getPoint().x, event.getPoint().y));

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
