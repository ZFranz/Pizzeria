package pizzeria;

public class Cliente implements Runnable {
	private ListaPizza lp;
	String testo;
	
	public Cliente(ListaPizza lp, String testo) {
		this.lp = lp;
		this.testo = testo;
	}
	
	public void run() {
		System.out.println(testo);
	}
}
