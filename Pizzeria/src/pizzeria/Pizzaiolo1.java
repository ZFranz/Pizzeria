package pizzeria;

public class Pizzaiolo1 implements Runnable {
	private ListaPizza lp;
	
	public Pizzaiolo1(ListaPizza lp) {
		this.lp = lp;
	}
	
	public void run() {
		while(true) {
			lp.pizzaInLista();
		}
	}
}
