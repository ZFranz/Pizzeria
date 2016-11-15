package pizzeria;

import java.util.ArrayList;

public class ListaPizza {
	
	ArrayList<String> ordini;
	ArrayList<String> pizzePronte;
	String temp;
	Pizzeria pizzeria;
	Boolean pronto = true;
	
	public ListaPizza() {
		ordini = new ArrayList<String>(); 
		pizzePronte = new ArrayList<String>();
	}
	
	public synchronized void aggiornaPizzeria(String pizza) {
		pizzeria.removePizzaProduzione(pizza);
		pizzeria.addPizzaPronta(pizza);
		pizzePronte.add(pizza);
		System.out.println(pizzePronte);
		pronto = false;
		notifyAll();
	}
	
	public synchronized String pizzaInLista() {
		while(ordini.isEmpty()) {
			try {
				System.out.println("nessuna pizza in lista");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String t = ordini.remove(0);
		pizzeria.removePizzaOrdinata(t);
		pizzeria.addPizzaProduzione(t);
		
		temp = t;
		notifyAll();
		
		return temp;
	}
	
	public synchronized void pizzaPronta(String pizzaSelezionata) {
		// finché non è pronta wait
		while(pronto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pizzaSelezionata == pizzePronte.get(0)) {
			System.out.println("Pizza ritirata: " + pizzaSelezionata);
			pizzeria.removePizzaPronta(pizzaSelezionata);
			pizzePronte.remove(0);
		}
		
		pronto = true;
		notifyAll();
	}
	
	public synchronized void ordinaPizza(String pizza, Pizzeria pizzeria) {
		ordini.add(pizza);
		this.pizzeria = pizzeria;
		notifyAll();
	}
}