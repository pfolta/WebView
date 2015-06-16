/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			Main.java
 * Created:			2014/3/30
 * Last modified:	2015/6/16
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import net.peterfolta.webview.gui.GUI;
import net.peterfolta.webview.gui.MessageBox;

public class Main {
	
	private static GUI gui;
	
	public static void main(String[] args) {
		if (args.length == 0) {
			new MessageBox(new Shell(), "No WebView Application File specified.", "WebView", SWT.ERROR, SWT.OK);
			System.exit(1);
		}
		
		
		System.setProperty("org.eclipse.swt.browser.XULRunnerPath", System.getProperty("user.dir") + System.getProperty("file.separator") + "browser");
		
		
		gui = new GUI();
		
		gui.start();
	}
	
	public static void exit(int status) {
		try {
			gui.die();
		} catch(Exception exception) {
		}
		
		System.exit(status);
	}
	
}