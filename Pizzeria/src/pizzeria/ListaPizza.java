package pizzeria;

import org.apache.commons.lang3.StringUtils;

public class ListaPizza {
	
	String ordine;
	String temp;
	Pizzeria pizzeria;
	
	public ListaPizza() {
		ordine = "";
	}
	
	public synchronized String pizzaInLista() {
		while(StringUtils.isBlank(ordine)) {
			try {
				System.out.println("nessuna pizza");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*pizzeria.removePizzaOrdinata(ordine);
		pizzeria.addPizzaProduzione(ordine);
		
		temp = ordine;
		ordine = "";
		notifyAll();
		*/
		return "ciao";
		/*switch (ordine) {
			case "Pizza bianca":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(5000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Pizza bianca");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
	
			case "Pizza rossa":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(6000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Pizza rossa");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Margherita":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(7000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Margherita");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Capricciosa":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(10000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Capricciosa");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Diavola":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(8000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Diavola");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Quattro stagioni":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(11000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Quattro stagioni");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Bufala":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(10000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Bufala");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			case "Napoletana":
				try {
					pizzeria.removePizzaOrdinata(ordine);
					pizzeria.addPizzaProduzione(ordine);
					Thread.sleep(9000);
					pizzeria.removePizzaProduzione(ordine);
					pizzeria.addPizzaPronta(ordine);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Napoletana");
				temp = ordine;
				ordine = "";
				notifyAll();
				break;
				
			default:
				break;
		}*/
	}
	
	public synchronized void pizzaPronta() {
		// finché non è pronta wait
		//while()
	}
	
	public synchronized void ordinaPizza(String pizza, Pizzeria pizzeria) {
		ordine = pizza;
		this.pizzeria = pizzeria;
		notifyAll();
	}
}