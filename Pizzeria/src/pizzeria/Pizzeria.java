package pizzeria;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
		shell.setSize(450, 300);
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
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(25, 90, 85, 85);
	    scrolledComposite.setExpandHorizontal(false);
		scrolledComposite.setExpandVertical(true);
	}
}
