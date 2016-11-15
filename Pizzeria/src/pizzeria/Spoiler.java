package pizzeria;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.wb.swt.SWTResourceManager;

public class Spoiler {

	protected Shell shlForbidden;
	Label lblNewLabel;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Spoiler window = new Spoiler();
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
		shlForbidden.open();
		shlForbidden.layout();
		while (!shlForbidden.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws IOException 
	 */
	protected void createContents() {
		shlForbidden = new Shell();
		shlForbidden.setSize(800, 300);
		shlForbidden.setText("Forbidden");
		lblNewLabel = new Label(shlForbidden, SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		Font font = new Font( lblNewLabel.getDisplay(), new FontData( "Arial", 40, 0 ) );
		lblNewLabel.setFont( font );
		
		
		lblNewLabel.setBounds(10, 10, 764, 242);
		lblNewLabel.setText("Non inserisca\nDemian o Igor,\naltrimenti non\npotrà ordinare le pizze.");
		

	}
}
