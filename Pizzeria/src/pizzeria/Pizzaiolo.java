package pizzeria;

import org.apache.commons.lang3.StringUtils;

public class Pizzaiolo implements Runnable {
	private ListaPizza lp;
	private String pizza;
	
	public Pizzaiolo(ListaPizza lp) {
		this.lp = lp;
	}
	
	public void run() {
		while(true) {
			pizza = lp.pizzaInLista();
			
			if(StringUtils.isBlank(pizza)) {
				System.out.println("Niente pizza");
			} else {
				switch (pizza) {
					case "Pizza bianca":
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Pizza bianca");
						break;
			
					case "Pizza rossa":
						try {
							Thread.sleep(6000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Pizza rossa");
						break;
						
					case "Margherita":
						try {
							Thread.sleep(7000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Margherita");
						break;
						
					case "Capricciosa":
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Capricciosa");
						break;
						
					case "Diavola":
						try {
	
							Thread.sleep(8000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Diavola");
						break;
						
					case "Quattro stagioni":
						try {
							Thread.sleep(11000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Quattro stagioni");
						break;
						
					case "Bufala":
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Bufala");
						break;
						
					case "Napoletana":
						try {
							Thread.sleep(9000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lp.aggiornaPizzeria(pizza);
						System.out.println("Napoletana");
						break;
						
					default:
						try {
							Thread.sleep(1000);
							System.out.println("Zero");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
				}
				pizza = "";
			}
		}
	}
}
