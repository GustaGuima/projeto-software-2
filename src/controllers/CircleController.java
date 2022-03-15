package controllers;

import java.awt.Graphics;

import domain.Circle;
import domain.Point;
import interfaces.Shape;

public class CircleController implements Shape{

	private Circle circulo;

	public CircleController(Circle c) {
		this.circulo = c;
	}

	@Override
	public void click(int x, int y) {
		circulo.setA(new Point(x, y));
	}

	@Override
	public void press(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drag(int x, int y) {
		circulo.setB(new Point(x, y));
	}

	public void paint(Graphics g) {
		
		double xTop = Math.min(circulo.getB().x, circulo.getA().x);
		double yTop = Math.min(circulo.getB().y, circulo.getA().y);
		double xBottom = Math.max(circulo.getB().x, circulo.getA().x);
		double yBottom = Math.max(circulo.getB().y, circulo.getA().y);

		double radius = Math.max(xBottom - xTop, yBottom - yTop);
		xTop = circulo.getA().x - radius;
		yTop = circulo.getA().y - radius;

		radius *= 2;

		int r = (int) Math.round(radius);

		int x = circulo.getA().getX() - (r / 2);
		int y = circulo.getA().getY() - (r / 2);
		g.drawOval(x, y, r, r);

	}
}
