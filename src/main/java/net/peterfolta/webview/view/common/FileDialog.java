/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            FileDialog.java
 * Created:         2015-07-29
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view.common;

import org.eclipse.swt.widgets.Shell;

public class FileDialog {

	private org.eclipse.swt.widgets.FileDialog dialog;

	private String path;
	
	public FileDialog(Shell parent, int type, String title, String defaultPath, String[] filterNames, String[] filterExtensions, int defaultFilter) {
		dialog = new org.eclipse.swt.widgets.FileDialog(parent, type);
		
		dialog.setText(title);
		dialog.setFilterPath(defaultPath);
		dialog.setFilterNames(filterNames);
		dialog.setFilterExtensions(filterExtensions);
		dialog.setFilterIndex(defaultFilter);
		
		path = dialog.open();
	}
	
	public String getPath() {
		return path;
	}

}