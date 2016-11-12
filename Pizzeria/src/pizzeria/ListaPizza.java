package pizzeria;

public class ListaPizza {
	
	String ordine;
	String temp;
	
	public ListaPizza() {
		ordine = "";
	}
	
	public synchronized String pizzaInLista() {
		while(ordine.equals("")) {
			try {
				System.out.println("nessuna pizza");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch (ordine) {
			case "Pizza bianca":
				try {
					Thread.sleep(5000);
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
					Thread.sleep(6000);
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
					Thread.sleep(7000);
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
					Thread.sleep(10000);
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
					Thread.sleep(8000);
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
					Thread.sleep(11000);
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
					Thread.sleep(10000);
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
					Thread.sleep(9000);
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
		}
		return temp;
	}
	
	public synchronized void pizzaPronta() {
		
	}
	
	public synchronized void ordinaPizza(String pizza) {
		ordine = pizza;
		notifyAll();
	}
}
