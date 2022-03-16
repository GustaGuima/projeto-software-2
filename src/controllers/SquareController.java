package controllers;

import java.awt.Graphics;

import domain.Point;
import domain.Square;
import interfaces.Shape;

public class SquareController implements Shape {
    private Square square;

    public SquareController(Square square) {
        this.square = square;
    }

    @Override
    public void paint(Graphics g) {
    	double ax, ay, bx, by;
        ax = square.getA().getX();
        ay = square.getA().getY();
        bx = square.getB().getX();
        by = square.getB().getY();
     
        int r = (int) Math.sqrt( Math.pow(bx - ax, 2) + Math.pow(by - ay, 2) );

        int x = square.getA().getX() - (r/2);
        int y = square.getA().getY() - (r/2);
        
        g.drawRect(x,y,r,r);
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
        square.setB(new Point(x, y));
    }


}