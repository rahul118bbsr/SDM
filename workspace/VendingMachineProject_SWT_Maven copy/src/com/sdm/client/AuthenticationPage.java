/**
 * 
 */
package com.sdm.client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.sdm.client.listener.AuthenticationPageButtonListener;
import com.sdm.server.controller.IAuthenticator;

/**
 * This class provides the user with a frame wherein the user can enter the login ID.
 * Valid user names are: Bob, Sean and Lisa
 * 
 * @author Rahul Dev Mishra
 * @assignment Assignment 7
 * @date 21-Nov-2016 7:45:15 AM
 *
 */
public class AuthenticationPage {
	private IAuthenticator authenticator;
	private Shell shell;
	private Text title;
	
	public AuthenticationPage(IAuthenticator authenticator) {
		this.authenticator = authenticator;
	}

	public void execute() {
		Display display = new Display();
		shell = new Shell(display);
		shell.setLayout(new GridLayout());
		shell.setText("Only the Best Ven");
		GridLayout gridLayout = new GridLayout(2, false);
	    gridLayout.verticalSpacing = 8;
	    shell.setLayout(gridLayout);
	    shell.setSize(500, 500);
	    
	    new Label(shell, SWT.NULL);

		Label label1 = new Label(shell, SWT.NULL);
		label1.setText("Welcome to Only The Best Ven. Please enter your ID for authentication.");

		Label label2 = new Label(shell, SWT.NULL);
		label2.setText("Enter ID: ");
		
		title = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		title.setLayoutData(gridData);
		title.setToolTipText("Few valid IDs: Bob, Lisa and Sean");

		Button enter = new Button(shell, SWT.PUSH);
		enter.setText("Login");
		gridData = new GridData();
	    gridData.horizontalSpan = 4;
	    gridData.horizontalAlignment = GridData.END;
	    enter.setLayoutData(gridData);
	    
	    enter.addSelectionListener(new AuthenticationPageButtonListener(authenticator, this));
	    
	    Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
	    
	    shell.addListener(SWT.Close, new Listener() {
	        public void handleEvent(Event event) {
	          System.exit(0);
	        }
	      });
	    
		shell.pack();
		shell.open();

		// Set up the event loop.
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
	
	public Shell getShell() {
		return shell;
	}
	
	public Text getTitle() {
		return title;
	}
}
