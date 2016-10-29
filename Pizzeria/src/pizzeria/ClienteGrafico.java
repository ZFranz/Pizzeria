package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ClienteGrafico {

	protected Shell shell;
	private Text text;
	ListaPizza listaPizza;

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
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(67, 121, 76, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Cliente c = new Cliente(listaPizza);
				
				Thread t = new Thread(c);
				t.start();
			}
		});
		btnNewButton.setBounds(193, 121, 75, 25);
		btnNewButton.setText("New Button");

	}
}
