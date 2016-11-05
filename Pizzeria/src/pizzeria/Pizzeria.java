package pizzeria;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Pizzeria {

	protected Shell shell;
	ListaPizza listaPizza = new ListaPizza();
	private Text text;
	String nomeCliente = "";

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
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
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
		ScrolledComposite scrolledCompositePizzeInAttesa = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		ScrolledComposite scrolledCompositePizzeInProduzione = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		ScrolledComposite scrolledCompositePizzePronte = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Label labelPizzeInCoda = new Label(shell, SWT.NONE);
		Label lblPizzeInProduzione = new Label(shell, SWT.NONE);
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		
		Pizzaiolo1 p1 = new Pizzaiolo1(listaPizza);
		Thread t = new Thread(p1);
		
		apriPizzeria.setBounds(10, 10, 75, 25);
		apriPizzeria.setText("Apri Pizzeria");
		apriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria aperta");
				ArrivaCliente.setEnabled(true);
				
				t.start();
			}
		});
		
		chiudiPizzeria.setBounds(91, 10, 89, 25);
		chiudiPizzeria.setText("Chiudi Pizzeria");
		chiudiPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria chiusa");
				ArrivaCliente.setEnabled(false);
				
			}
		});
		
		lblNomeCliente.setBounds(202, 20, 75, 15);
		lblNomeCliente.setText("Nome cliente");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(283, 14, 76, 21);

		ArrivaCliente.setEnabled(false);
		ArrivaCliente.setBounds(364, 10, 109, 25);
		ArrivaCliente.setText("Arriva un cliente!");
		ArrivaCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Arriva un cliente");
				nomeCliente = text.getText().toString();
				ClienteGrafico newWindow = new ClienteGrafico(listaPizza, nomeCliente);
				newWindow.open();
			}
		});
		
		scrolledCompositePizzeInAttesa.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzeInAttesa.setBounds(10, 90, 150, 350);
	    scrolledCompositePizzeInAttesa.setExpandHorizontal(false);
		scrolledCompositePizzeInAttesa.setExpandVertical(true);
		
		scrolledCompositePizzeInProduzione.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzeInProduzione.setBounds(170, 90, 150, 350);
		scrolledCompositePizzeInProduzione.setExpandHorizontal(true);
		scrolledCompositePizzeInProduzione.setExpandVertical(true);
		
		scrolledCompositePizzePronte.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzePronte.setBounds(330, 90, 150, 350);
		scrolledCompositePizzePronte.setExpandHorizontal(true);
		scrolledCompositePizzePronte.setExpandVertical(true);
		
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
	}
}
