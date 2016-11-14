package pizzeria;

public class Cliente implements Runnable {
	private ListaPizza lp;
	String nomeCliente;
	String pizzaSelezionata;
	Pizzeria pizzeria;
	
	public Cliente(ListaPizza lp, String nomeCliente, String pizzaSelezionata, Pizzeria pizzeria) {
		this.lp = lp;
		this.nomeCliente = nomeCliente;
		this.pizzaSelezionata = pizzaSelezionata;
		this.pizzeria = pizzeria;
	}
	
	public void run() {
		lp.ordinaPizza(pizzaSelezionata, pizzeria);
		lp.pizzaPronta();
	}
}
