package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;

public class ClienteGrafico {

	protected Shell shlOrdinaPizza;
	ListaPizza listaPizza;
	private List list;
	private String nomeCliente;
	private String temp;
	private static final String[] ITEMS ={
			"Pizza bianca",
			"Pizza rossa",
			"Margherita",
			"Capricciosa",
			"Diavola",
			"Quattro stagioni",
			"Bufala",
			"Napoletana" };
	private Label cliente;
	private Label pizzaSelezionata;

	public ClienteGrafico(ListaPizza listaPizza, String nomeCliente) {
		this.listaPizza = listaPizza;
		this.nomeCliente = nomeCliente;
	}
	
	public ClienteGrafico() {
		super();
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClienteGrafico window = new ClienteGrafico();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlOrdinaPizza.open();
		shlOrdinaPizza.layout();
		while (!shlOrdinaPizza.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlOrdinaPizza = new Shell();
		shlOrdinaPizza.setSize(220, 350);
		shlOrdinaPizza.setText("Ordina Pizza");
		
		list = new List(shlOrdinaPizza, SWT.BORDER | SWT.V_SCROLL);
		cliente = new Label(shlOrdinaPizza, SWT.NONE);
		Button ordina = new Button(shlOrdinaPizza, SWT.NONE);
		ordina.setEnabled(false);
		pizzaSelezionata = new Label(shlOrdinaPizza, SWT.NONE);
		
		cliente.setBounds(10, 10, 176, 15);
		cliente.setText("Cliente: " + nomeCliente);
		
		list.setBounds(10, 47, 176, 205);
		for(int i = 0; i < ITEMS.length; i++) {
			list.add(ITEMS[i]);
		}
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				temp = list.getItem(list.getSelectionIndex());
				ordina.setEnabled(true);
				pizzaSelezionata.setText(temp);
			}
		});
		
		ordina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Cliente c = new Cliente(listaPizza, nomeCliente, temp);
				
				Thread t = new Thread(c);
				t.start();
			}
		});
		ordina.setBounds(111, 277, 75, 25);
		ordina.setText("Ordina");
		
		pizzaSelezionata.setBounds(10, 282, 95, 15);
	}
}
