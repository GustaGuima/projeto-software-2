package formas;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorCirculo;

public class Circulo implements FormaGeometrica{
    public static final String NOME = "Circulo";
	public static final byte ID = 5;
	private Ponto a;
	private Ponto b;
	
	public Circulo() {
		this.a = new Ponto();
		this.b = new Ponto();
	}
	
	public Circulo(Circulo c) {
		this.a = c.getA();
		this.b = c.getB();
	}
	
	public Circulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}
	
	public Circulo(Ponto a, Ponto b) {
		this.a = a;
		this.b = b;
	}
		
	public Ponto getA() {
		return a;
	}

	public void setA(Ponto a) {
		this.a = a;
	}

	public Ponto getB() {
		return b;
	}

	public void setB(Ponto b) {
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
	public ManipuladorForma getManipulador() {
		return new ManipuladorCirculo(this);
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
