package controllers;

import java.awt.Graphics;

import domain.Point;
import interfaces.Shape;

public class PointController implements Shape{
    private Point ponto;

	public PointController(Point p) {
		this.ponto = p;
	}

	@Override
	public void click(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void press(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void release(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void drag(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void paint(Graphics g) {
		g.fillOval(ponto.getX(), ponto.getY(), 7, 7);
	}

}
