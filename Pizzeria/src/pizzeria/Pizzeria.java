package pizzeria;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

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
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 34, 75, 25);
		btnNewButton.setText("Apri Pizzeria");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(102, 34, 89, 25);
		btnNewButton_1.setText("Chiudi Pizzeria");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(305, 34, 109, 25);
		btnNewButton_2.setText("Arriva un cliente!");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 99, 71, 68);
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(149, 99, 71, 68);
	}
}
