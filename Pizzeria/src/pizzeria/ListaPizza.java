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
	
	public synchronized void ordinaPizza(String pizza) {
		switch (pizza) {
			case "Pizza bianca":
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Pizza bianca");
				notifyAll();
				break;
	
			case "Pizza rossa":
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Pizza rossa");
				notifyAll();
				break;
				
			case "Margherita":
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Margherita");
				notifyAll();
				break;
				
			case "Capricciosa":
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Capricciosa");
				notifyAll();
				break;
				
			case "Diavola":
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Diavola");
				notifyAll();
				break;
				
			case "Quattro stagioni":
				try {
					Thread.sleep(11000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Quattro stagioni");
				notifyAll();
				break;
				
			case "Bufala":
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Bufala");
				notifyAll();
				break;
				
			case "Napoletana":
				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Napoletana");
				notifyAll();
				break;
				
			default:
				break;
		}
	}
}
