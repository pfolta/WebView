/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            MessageBox.java
 * Created:         2015-06-16
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view.common;

import org.eclipse.swt.widgets.Shell;

public class MessageBox {

	private org.eclipse.swt.widgets.MessageBox messageBox;

	private int returnCode;

	public MessageBox(Shell parent, String text, String title, int icon, int buttons) {
		messageBox = new org.eclipse.swt.widgets.MessageBox(parent, icon | buttons);
		messageBox.setText(title);
		messageBox.setMessage(text);
		
		returnCode = messageBox.open();
	}

	public int getReturnCode() {
		return returnCode;
	}

}