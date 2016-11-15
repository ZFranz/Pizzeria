package pizzeria;

import org.apache.commons.lang3.StringUtils;

public class Pizzaiolo1 implements Runnable {
	private ListaPizza lp;
	private String pizza;
	
	public Pizzaiolo1(ListaPizza lp) {
		this.lp = lp;
	}
	
	public void run() {
		while(true) {
			pizza = lp.pizzaInLista();
			if(StringUtils.isBlank(pizza)) {
				System.out.println("Niente pizza");
			} else {
				System.out.println("Pizza");
			}
			
			/*switch (ordine) {
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
			}*/
		}
	}
}
