package controllers;

import java.awt.Graphics;

import domain.Point;
import domain.Rectangle;
import interfaces.Shape;

public class RectangleController implements Shape {
	private Rectangle rectangle;

	public RectangleController(Rectangle r) {
		this.rectangle = r;
	}

	@Override
	public void click(int x, int y) {

	}

	@Override
	public void press(int x, int y) {
	}

	@Override
	public void release(int x, int y) {
	}

	@Override
	public void drag(int x, int y) {
		rectangle.setB(new Point(x, y));
	}

	@Override
	public void paint(Graphics g) {

		int px = Math.min(rectangle.getA().getX(), rectangle.getB().getX());
		int py = Math.min(rectangle.getA().getY(), rectangle.getB().getY());
		int pw = Math.abs(rectangle.getA().getX() - rectangle.getB().getX());
		int ph = Math.abs(rectangle.getA().getY() - rectangle.getB().getY());

		g.drawRect(px, py, pw, ph);
	}

}
