package pizzeria;

public class listaPizza {
	
	private int numero=0;
	
	public listaPizza() {
		numero = 0;
	}
	
	public synchronized void pizzaInLista() {
		while(numero!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void pizzaPronta() {
		
	}
	
	public synchronized void ordinaPizza() {
		
	}
}
