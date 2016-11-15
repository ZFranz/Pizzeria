package pizzeria;

import org.apache.commons.lang3.StringUtils;

public class ListaPizza {
	
	String ordine;
	String temp;
	Pizzeria pizzeria;
	
	public ListaPizza() {
		ordine = "";
	}
	
	public synchronized void aggiornaPizzeria(String pizza) {
		pizzeria.removePizzaProduzione(pizza);
		pizzeria.addPizzaPronta(pizza);
	}
	
	public synchronized String pizzaInLista() {
		while(StringUtils.isBlank(ordine)) {
			try {
				System.out.println("nessuna pizza in lista");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pizzeria.removePizzaOrdinata(ordine);
		pizzeria.addPizzaProduzione(ordine);
		
		temp = ordine;
		ordine = "";
		notifyAll();
		
		return temp;
	}
	
	public synchronized void pizzaPronta(Boolean pronto) {
		// finché non è pronta wait
		while(pronto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		pronto = true;
	}
	
	public synchronized void ordinaPizza(String pizza, Pizzeria pizzeria) {
		ordine = pizza;
		this.pizzeria = pizzeria;
		notifyAll();
	}
}