package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class ClienteGrafico {

	protected Shell shlOrdinaPizza;
	ListaPizza listaPizza;
	private List list;
	private Text text;
	private static final String[] ITEMS ={
			"Pizza bianca",
			"Pizza rossa",
			"Margherita",
			"Capricciosa",
			"Diavola",
			"Quattro stagioni",
			"Bufala",
			"Napoletana" };

	public ClienteGrafico(ListaPizza listaPizza) {
		this.listaPizza = listaPizza;
		// TODO Auto-generated constructor stub
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
		shlOrdinaPizza.setSize(450, 300);
		shlOrdinaPizza.setText("Ordina Pizza");
		
		list = new List(shlOrdinaPizza, SWT.BORDER | SWT.V_SCROLL);
		list.setBounds(10, 10, 150, 242);
		for(int i = 0; i < ITEMS.length; i++) {
			list.add(ITEMS[i]);
		}
		
		text = new Text(shlOrdinaPizza, SWT.BORDER);
		text.setBounds(176, 10, 76, 21);
		
		Button ordina = new Button(shlOrdinaPizza, SWT.NONE);
		ordina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String testo = text.getText();
				Cliente c = new Cliente(listaPizza, testo);
				
				Thread t = new Thread(c);
				t.start();
			}
		});
		ordina.setBounds(281, 9, 75, 25);
		ordina.setText("Ordina");
	}
}
