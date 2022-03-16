package domain;

import interfaces.GeometricShape;
import interfaces.Shape;
import controllers.PointController;

public class Point implements GeometricShape{
    public static final String NOME = "Point";
	public static final byte ID = 1;
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
        x = p.getX();
        y = p.getY();
    }

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toTextLine() {
		return NOME + " " + x + " " + y;
	}
	
	@Override
	public String toTextLineBD() {
        return x+","+y;

    }

	@Override
	public String toString() {
		return NOME;
	}
	
	public String toStringArq() {
		return String.format("%d %d", x, y);
	}

	@Override
	public Shape getController() {
		return new PointController(this);
	}
	
	@Override
    public String getStrPosition() {
        return "Ponto ("+x+", "+y+");";
    }
	
}
