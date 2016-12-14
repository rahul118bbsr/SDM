/**
 * 
 */
package com.sdm.client.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;

import com.sdm.client.AuthenticationPage;
import com.sdm.common.exception.IdAuthneticationException;
import com.sdm.server.controller.IAuthenticator;

/**
 * This is a listener class which listens to Login button of the authentication page. After button click, authenticate the user.s
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7
 * @date 21-Nov-2016 8:15:49 AM
 *
 */
public class AuthenticationPageButtonListener implements SelectionListener {
	private IAuthenticator authenticator;
	private AuthenticationPage authenticationPage;
	
	public AuthenticationPageButtonListener(IAuthenticator authenticator, AuthenticationPage authenticationPage) {
		this.authenticator = authenticator;
		this.authenticationPage = authenticationPage;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent event) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent event) {
		try {
		authenticator.authenticateId(authenticationPage.getTitle().getText());
		authenticationPage.getShell().dispose();
		} catch(IdAuthneticationException e) {
			int style = SWT.ICON_ERROR | SWT.OK;
	        MessageBox dia = new MessageBox(authenticationPage.getShell(), style);
	        dia.setText("Only the Best Ven");
	        dia.setMessage(e.getMessage()); 
	        dia.open();
		}
	}

}
