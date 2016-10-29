package pizzeria;

public class ListaPizza {
	
	private String pizza;
	
	public ListaPizza() {
		pizza = "";
	}
	
	public synchronized String pizzaInLista(String pizza) {
		this.pizza = pizza;
		while(pizza.equals("")) {
			try {
				System.out.println("nessuna pizza");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		return pizza;
	}
	
	public synchronized void pizzaPronta() {
		
	}
	
	public synchronized void ordinaPizza() {
		
	}
}
