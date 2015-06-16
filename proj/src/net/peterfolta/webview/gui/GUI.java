/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			GUI.java
 * Created:			2014/3/30
 * Last modified:	2015/6/16
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui;

import org.eclipse.swt.widgets.Display;

public class GUI extends Thread {
	
	private static Display display;
	
	public void run() {
		display = getDisplay();
		
		new BrowserWindow(display);
		
		while(!display.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public Display getDisplay() {
		if(display == null) {
			display = new Display();
		}
		
		return display;
	}
	
	public void die() {
		display.dispose();
	}

}