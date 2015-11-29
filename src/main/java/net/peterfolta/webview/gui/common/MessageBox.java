/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			MessageBox.java
 * Created:			2015/6/16
 * Last modified:	2015/7/29
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui.common;

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