package pizzeria;

public class Pizzaiolo2 implements Runnable {
	private ListaPizza lp;
	
	public Pizzaiolo2(ListaPizza lp) {
		this.lp = lp;
	}
	
	public void run() {
		while(true) {
			lp.pizzaInLista();
		}
	}
}
