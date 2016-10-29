package pizzeria;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Pizzeria {

	protected Shell shell;

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
		shell.setSize(450, 492);
		shell.setText("Pizzeria");
		
		Button apriPizzeria = new Button(shell, SWT.NONE);
		apriPizzeria.setBounds(10, 34, 75, 25);
		apriPizzeria.setText("Apri Pizzeria");
		apriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria aperta");
				ListaPizza listaPizza = new ListaPizza();
				Pizzaiolo1 p1 = new Pizzaiolo1(listaPizza);
				
				Thread t = new Thread(p1);
				t.start();
			}
		});
		
		Button chiudiPizzeria = new Button(shell, SWT.NONE);
		chiudiPizzeria.setBounds(102, 34, 89, 25);
		chiudiPizzeria.setText("Chiudi Pizzeria");
		chiudiPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria chiusa");
			}
		});
		
		Button ArrivaCliente = new Button(shell, SWT.NONE);
		ArrivaCliente.setBounds(305, 34, 109, 25);
		ArrivaCliente.setText("Arriva un cliente!");
		ArrivaCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Arriva un cliente");
			}
		});
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		composite.setBounds(0, 53, 484, 368);
		
		ScrolledComposite scrolledCompositePizzeInAttesa = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledCompositePizzeInAttesa.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzeInAttesa.setBounds(10, 90, 149, 322);
	    scrolledCompositePizzeInAttesa.setExpandHorizontal(false);
		scrolledCompositePizzeInAttesa.setExpandVertical(true);
		
		ScrolledComposite scrolledCompositePizzeInProduzione = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledCompositePizzeInProduzione.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzeInProduzione.setBounds(165, 90, 158, 322);
		scrolledCompositePizzeInProduzione.setExpandHorizontal(true);
		scrolledCompositePizzeInProduzione.setExpandVertical(true);
		
		ScrolledComposite scrolledCompositePizzePronte = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledCompositePizzePronte.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledCompositePizzePronte.setBounds(329, 90, 145, 322);
		scrolledCompositePizzePronte.setExpandHorizontal(true);
		scrolledCompositePizzePronte.setExpandVertical(true);
		
		Label labelPizzeInCoda = new Label(shell, SWT.NONE);
		labelPizzeInCoda.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		labelPizzeInCoda.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		labelPizzeInCoda.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		labelPizzeInCoda.setText("Pizze in coda:");
		labelPizzeInCoda.setBounds(10, 69, 98, 15);
		
		Label lblPizzeInProduzione = new Label(shell, SWT.NONE);
		lblPizzeInProduzione.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		lblPizzeInProduzione.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPizzeInProduzione.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblPizzeInProduzione.setBounds(165, 69, 149, 15);
		lblPizzeInProduzione.setText("Pizze in produzione:");
		
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		lblPizzePronte.setFont(SWTResourceManager.getFont("Letter Gothic Std", 8, SWT.BOLD));
		lblPizzePronte.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPizzePronte.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblPizzePronte.setBounds(329, 69, 98, 15);
		lblPizzePronte.setText("Pizze pronte:");
	}
}
