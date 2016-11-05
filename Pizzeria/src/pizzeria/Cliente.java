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
		switch (pizzaSelezionata) {
			case "Pizza bianca":
				System.out.println("Pizza bianca");
				break;
	
			case "Pizza rossa":
				System.out.println("Pizza rossa");
				break;
				
			case "Margherita":
				System.out.println("Margherita");
				break;
				
			case "Capricciosa":
				System.out.println("Capricciosa");
				break;
				
			case "Diavola":
				System.out.println("Diavola");
				break;
				
			case "Quattro stagioni":
				System.out.println("Quattro stagioni");
				break;
				
			case "Bufala":
				System.out.println("Bufala");
				break;
				
			case "Napoletana":
				System.out.println("Napoletana");
				break;
				
			default:
				break;
		}
	}
}
