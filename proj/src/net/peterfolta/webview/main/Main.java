/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			Main.java
 * Created:			2014/03/30
 * Last modified:	2015/06/15
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

import net.peterfolta.webview.gui.GUI;

public class Main {
	
	private static GUI gui;
	
	public static void main(String[] args) {
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