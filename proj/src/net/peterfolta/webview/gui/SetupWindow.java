/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			SetupWindow.java
 * Created:			2015/6/16
 * Last modified:	2015/6/16
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui;

import net.peterfolta.webview.main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SetupWindow {
	
	private Shell setupShell;
	
	public SetupWindow(Display display) {
		setupShell = new Shell(display, SWT.TITLE | SWT.MIN | SWT.CLOSE);
		setupShell.setText("WebView");
		
		setupShell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent event) {
			}

			public void shellClosed(ShellEvent event) {
				Main.exit(0);
			}

			public void shellDeactivated(ShellEvent event) {
			}

			public void shellDeiconified(ShellEvent event) {
			}

			public void shellIconified(ShellEvent event) {
			}
		});
		
		setupShell.setLayout(new FillLayout());

		setupShell.setSize(480, 640);
		GUI.centerShellOnPrimaryMonitor(setupShell);
		setupShell.open();
	}
	
}