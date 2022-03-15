package main;
import view.Window;

public final class Main {
	
	private static Main principal;
	
	private Main() {
		new Window().setVisible(true);;
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
