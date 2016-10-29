package pizzeria;

public class Cliente implements Runnable {
	private ListaPizza lp;
	
	public Cliente(ListaPizza lp) {
		this.lp = lp;
	}
	
	public void run() {
		System.out.println("Ciao prof");
	}
}
