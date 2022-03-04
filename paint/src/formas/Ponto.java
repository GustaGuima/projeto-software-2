package formas;

import utils.FormaGeometrica;
import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorPonto;

public class Ponto implements FormaGeometrica{
    public static final String NOME = "Ponto";
	public static final byte ID = 1;
	public int x;
	public int y;

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto p) {
        x = p.getX();
        y = p.getY();
    }

	public Ponto() {
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
	public ManipuladorForma getManipulador() {
		return new ManipuladorPonto(this);
	}
	
	@Override
    public String getStrPosition() {
        return "Ponto ("+x+", "+y+");";
    }
	
	// Para salavar em bin�rio
}
