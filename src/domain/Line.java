package domain;

import interfaces.GeometricShape;
import interfaces.Shape;
import controllers.LineController;

public class Line implements GeometricShape{
    public static final byte ID = 2;
	public static final String NOME = "Linha";
	Point ponto1;
	Point ponto2;
	
	public Line() {
		this.ponto1 = new Point();
		this.ponto2 = new Point();
	}
	
	public Line(Point p) {
		this.ponto1 = new Point(p);
		this.ponto2 = new Point(p);
	}
	
	public Line(Point ponto1, Point ponto2) {
		this.ponto1 = (Point) ponto1;
		this.ponto2 = (Point) ponto2;
	}
	
	public Point getPonto1() {
		return ponto1;
	}

	public void setPonto1(Point ponto1) {
		this.ponto1 = ponto1;
	}

	public Point getPonto2() {
		return ponto2;
	}

	public void setPonto2(Point ponto2) {
		this.ponto2 = ponto2;
	}
	
	@Override
	public String toString() {
		return NOME;
	}

	
	@Override
	public String toTextLine() {
		return NOME+" "+ponto1.getX()+" "+ponto1.getY()+" "+ponto2.getX()+" "+ponto2.getY();
	}
	
	@Override
    public String toTextLineBD() {
		return ponto1.getX()+","+ponto1.getY()+" | "+ponto2.getX()+","+ponto2.getY();

	}
	
	public String toStringArq(){
		return String.format("%d %d %d %d", ponto1.x, ponto1.y, ponto2.x, ponto2.y);
	}

	@Override
	public Shape getController() {
		return new LineController(this);
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+ponto1.getX()+", "+ponto1.getY()+"),("+ponto2.getX()+", "+ponto2.getY()+");";
	}
}
