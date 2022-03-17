package main;
import controllers.DocumentoController;
import view.Window;

public final class Main {
	
	private static Main principal;
	private DocumentoController documento;
	
	private Main() {
		this.documento = new DocumentoController();
		new Window(this.documento).setVisible(true);
	}

	public static Main getPrincipal() {
		if(Main.principal == null)
			Main.principal = new Main();
		return Main.principal;
	}
	
	
	public static void main(String[] args) {
			Main.getPrincipal();
	}

}
