package pizzeria;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Pizzeria {

	protected Shell shell;
	ListaPizza listaPizza = new ListaPizza();
	private Text text;
	String nomeCliente = "";
	Pizzeria pizzeria;
	List pizzeInCoda;
	List pizzeInProduzione;
	List pizzePronte;
	Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Pizzeria window = new Pizzeria();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		pizzeria = this;
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void addPizzaOrdinata(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzeInCoda.add(p);
			}
		});		
	}
	
	public void removePizzaOrdinata(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzeInCoda.remove(p);
			}
		});
	}
	
	public void addPizzaProduzione(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzeInProduzione.add(p);
			}
		});
	}
	
	public void removePizzaProduzione(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzeInProduzione.remove(p);
			}
		});
	}
	
	public void addPizzaPronta(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzePronte.add(p);
			}
		});
	}
	
	public void removePizzaPronta(String p) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				pizzePronte.remove(p);
			}
		});
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		shell.setSize(505, 500);
		shell.setText("Pizzeria");
		
		Button apriPizzeria = new Button(shell, SWT.NONE);
		Button chiudiPizzeria = new Button(shell, SWT.NONE);
		Label lblNomeCliente = new Label(shell, SWT.NONE);
		Button ArrivaCliente = new Button(shell, SWT.NONE);
		Label labelPizzeInCoda = new Label(shell, SWT.NONE);
		Label lblPizzeInProduzione = new Label(shell, SWT.NONE);
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		pizzeInCoda = new List(shell, SWT.BORDER);
		pizzeInProduzione = new List(shell, SWT.BORDER);
		pizzePronte = new List(shell, SWT.BORDER);
		Label apertoChiuso = new Label(shell, SWT.NONE);
		apertoChiuso.setFont(SWTResourceManager.getFont("Shonar Bangla", 10, SWT.BOLD));
		
		Pizzaiolo p1 = new Pizzaiolo(listaPizza);
		Pizzaiolo p2 = new Pizzaiolo(listaPizza);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		/*Spoiler newWindow = new Spoiler();
		newWindow.open();*/
		
		apriPizzeria.setBounds(10, 10, 75, 25);
		apriPizzeria.setText("Apri Pizzeria");
		apriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria aperta");
				apertoChiuso.setText("Pizzeria aperta");
				ArrivaCliente.setEnabled(true);
				apriPizzeria.setEnabled(false);
				chiudiPizzeria.setEnabled(true);
				
				t1.start();
				t2.start();
			}
		});
		
		chiudiPizzeria.setBounds(91, 10, 89, 25);
		chiudiPizzeria.setText("Chiudi Pizzeria");
		chiudiPizzeria.setEnabled(false);
		chiudiPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria chiusa");
				apertoChiuso.setText("Pizzeria chiusa");
				ArrivaCliente.setEnabled(false);
				apriPizzeria.setEnabled(true);
				chiudiPizzeria.setEnabled(false);
			}
		});
		
		lblNomeCliente.setBounds(202, 20, 75, 15);
		lblNomeCliente.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblNomeCliente.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNomeCliente.setText("Nome cliente");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(283, 14, 76, 21);

		ArrivaCliente.setEnabled(false);
		ArrivaCliente.setBounds(364, 10, 109, 25);
		ArrivaCliente.setText("Arriva un cliente!");
		ArrivaCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text.getText().equals("Demian")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				    messageBox.setMessage("No è arrivato Demian, scappiamo tutti!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				    messageBox.open();
				    shell.close();
				} else if(text.getText().equals("Igor")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				    messageBox.setMessage("No è arrivato Igor, scappiamo tutti!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				    messageBox.open();
				    shell.close();
				} 
				else if (StringUtils.isBlank(text.getText())) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				    messageBox.setMessage("Nessun nome inserito.");
				    messageBox.open();
				} else {
					System.out.println("Arriva un cliente");
					nomeCliente = text.getText().toString();
					ClienteGrafico newWindow = new ClienteGrafico(listaPizza, nomeCliente, pizzeria);
					newWindow.open();
				}
			}
		});
		
		labelPizzeInCoda.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		labelPizzeInCoda.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		labelPizzeInCoda.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		labelPizzeInCoda.setText("Pizze in coda:");
		labelPizzeInCoda.setBounds(10, 69, 150, 15);
		
		lblPizzeInProduzione.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		lblPizzeInProduzione.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPizzeInProduzione.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblPizzeInProduzione.setBounds(170, 69, 150, 15);
		lblPizzeInProduzione.setText("Pizze in produzione:");
		
		lblPizzePronte.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		lblPizzePronte.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPizzePronte.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblPizzePronte.setBounds(330, 69, 150, 15);
		lblPizzePronte.setText("Pizze pronte:");
		
		pizzeInCoda.setBounds(10, 90, 150, 350);
		pizzeInProduzione.setBounds(170, 90, 150, 350);
		pizzePronte.setBounds(330, 90, 150, 350);
		
		apertoChiuso.setBounds(10, 41, 170, 15);
		apertoChiuso.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		apertoChiuso.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		apertoChiuso.setText("Pizzeria chiusa");
	}
}
