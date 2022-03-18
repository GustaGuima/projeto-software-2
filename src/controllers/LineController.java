package controllers;

import java.awt.Graphics;

import domain.Line;
import domain.Point;
import interfaces.Shape;

public class LineController implements Shape {

	private Line linha;

	public LineController(Line linha) {
		this.linha = linha;
	}

	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub

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
		linha.setPonto2(new Point(x, y));

	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(linha.getPonto1().getX(), linha.getPonto1().getY(), linha.getPonto2().getX(),
				linha.getPonto2().getY());
	}
}
