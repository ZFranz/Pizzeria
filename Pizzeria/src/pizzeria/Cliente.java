package pizzeria;

public class Cliente implements Runnable {
	private ListaPizza lp;
	String nomeCliente;
	String pizzaSelezionata;
	
	public Cliente(ListaPizza lp, String nomeCliente, String pizzaSelezionata) {
		this.lp = lp;
		this.nomeCliente = nomeCliente;
		this.pizzaSelezionata = pizzaSelezionata;
	}
	
	public void run() {
		lp.ordinaPizza(pizzaSelezionata);
	}
}
