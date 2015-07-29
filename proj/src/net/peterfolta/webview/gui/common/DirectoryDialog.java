/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			DirectoryDialog.java
 * Created:			2015/7/29
 * Last modified:	2015/7/29
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui.common;

import org.eclipse.swt.widgets.Shell;

public class DirectoryDialog {
	
	private org.eclipse.swt.widgets.DirectoryDialog dialog;
	
	private String path;
	
	public DirectoryDialog(Shell parent, String title, String message, String defaultPath) {
		dialog = new org.eclipse.swt.widgets.DirectoryDialog(parent);
		
		dialog.setText(title);
		dialog.setMessage(message);
		dialog.setFilterPath(defaultPath);
		
		path = dialog.open();
	}
	
	public String getPath() {
		return path;
	}

}