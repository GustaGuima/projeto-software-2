package formas;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorLinha;
import utils.FormaGeometrica;

public class Linha implements FormaGeometrica{
    public static final byte ID = 2;
	public static final String NOME = "Linha";
	Ponto ponto1;
	Ponto ponto2;
	
	public Linha() {
		this.ponto1 = new Ponto();
		this.ponto2 = new Ponto();
	}
	
	public Linha(Ponto p) {
		this.ponto1 = new Ponto(p);
		this.ponto2 = new Ponto(p);
	}
	
	public Linha(Ponto ponto1, Ponto ponto2) {
		this.ponto1 = (Ponto) ponto1;
		this.ponto2 = (Ponto) ponto2;
	}
	
	public Ponto getPonto1() {
		return ponto1;
	}

	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	public Ponto getPonto2() {
		return ponto2;
	}

	public void setPonto2(Ponto ponto2) {
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
	public ManipuladorForma getManipulador() {
		return new ManipuladorLinha(this);
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+ponto1.getX()+", "+ponto1.getY()+"),("+ponto2.getX()+", "+ponto2.getY()+");";
	}
}
