package domain;

import interfaces.GeometricShape;
import interfaces.Shape;
import controllers.RectangleController;

public class Rectangle implements GeometricShape {

	public static final byte ID = 4;
	public static final String NOME = "Rectangle";
	private Point a;
	private Point b;

	public Rectangle() {
		this.a = new Point();
		this.b = new Point();
	}

	public Rectangle(Point p) {
		this.a = new Point(p);
		this.b = new Point(p);
	}

	public Rectangle(Point a, Point b) {
		this.a = new Point(a);
		this.b = new Point(b);
	}

	public Rectangle(Rectangle r) {
		this.a = r.getA();
		this.b = r.getB();
	}

	@Override
	public String getStrPosition() {
		return NOME + " (" + a.getX() + ", " + a.getY() + "),(" + b.getX() + ", " + b.getY() + ");";
	}

	@Override
	public String toString() {
		return NOME;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	@Override
	public Shape getController() {
		return new RectangleController(this);
	}

	public String toStringArq() {
		return String.format("%d %d %d %d", a.x, a.y, b.x, b.y);
	}
}
