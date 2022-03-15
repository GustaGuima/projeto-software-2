package pacote;

public final class Principal {
	
	private static Principal principal;
	
	private Principal() {
		new MeuFrame();
	}
	
	
	public static Principal getPrincipal() {
		if(Principal.principal == null)
			Principal.principal = new Principal();
		return Principal.principal;
	}
	
	
	public static void main(String[] args) {
			Principal.getPrincipal();
	}

}
