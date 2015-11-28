/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			BrowserWindow.java
 * Created:			2014/3/30
 * Last modified:	2015/6/16
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui;

import net.peterfolta.webview.main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserWindow {
	
	private Shell browserShell;
	private Browser browser;
	
	public BrowserWindow(Display display) {
		browserShell = new Shell(display, SWT.TITLE | SWT.MIN | SWT.RESIZE | SWT.MAX | SWT.CLOSE);
		
		browserShell.addShellListener(new ShellListener() {
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
		
		browserShell.setLayout(new FillLayout());
		
		browser = new Browser(browserShell, SWT.MOZILLA);
		browser.setUrl("http://maps.google.com");
		browser.addTitleListener(new TitleListener() {
			@Override
			public void changed(TitleEvent event) {
				browserShell.setText(event.title);
			}
		});

		browserShell.setSize(1440, 900);
		browserShell.open();
	}
	
}