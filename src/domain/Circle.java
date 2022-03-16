package domain;

import controllers.CircleController;
import interfaces.GeometricShape;
import interfaces.Shape;

public class Circle implements GeometricShape{
    public static final String NOME = "Circle";
	public static final byte ID = 5;
	private Point a;
	private Point b;
	
	public Circle() {
		this.a = new Point();
		this.b = new Point();
	}
	
	public Circle(Circle c) {
		this.a = c.getA();
		this.b = c.getB();
	}
	
	public Circle(Point p) {
		this.a = new Point(p);
		this.b = new Point(p);
	}
	
	public Circle(Point a, Point b) {
		this.a = a;
		this.b = b;
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
	public String toString() {
		return NOME;
	}

	@Override
    public String toTextLineBD() {
		return a.getX()+","+a.getY()+" | "+b.getX()+","+b.getY();
    }

	@Override
	public Shape getController() {
		return new CircleController(this);
	}

	@Override
	public String toTextLine() {
		return NOME+" "+a.getX()+" "+a.getY()+" "+b.getX()+" "+b.getY();
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}
	
	public String toStringArq() {
		return String.format("%d %d %d %d", a.x,a.y,b.x, b.y);
	}
}
