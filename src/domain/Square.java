package domain;

import interfaces.GeometricShape;
import interfaces.Shape;
import controllers.SquareController;


public class Square implements GeometricShape {
	public static final long serialVersionUID = 2L;
	public static final byte ID = 5;

	public static final String NOME = "Square";
	private Point a;
	private Point b;
	
	public Square() {
		this.a = new Point();
		this.b = new Point();
	}

	public Square(Square square) {
		this.a = square.getA();
		this.b = square.getB();
	}

	public Square(Point p) {
		this.a = new Point(p);
		this.b = new Point(p);
	}

	public Square(Point a, Point b) {
		this.a = new Point(a);
		this.b = new Point(b);
	}

	@Override
	public Shape getController() {
		return new SquareController(this);
	}

	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
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
	public String toStringArq() {
		return String.format("%d %d %d %d", a.x, a.y, b.x, b.y);
	}
}