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

import net.peterfolta.webview.enums.OperationMode;
import net.peterfolta.webview.gui.GUI;
import net.peterfolta.webview.wvapp.WVApp;

public class Main {
	
	private static GUI gui;
	
	public static void main(String[] args) {
//		if (args.length == 0) {
//			gui = new GUI(OperationMode.SETUP_MODE);
//		} else {
//			gui = new GUI(OperationMode.APPLICATION_MODE);
//			
//			WVApp wvapp = new WVApp(args[0]);
//			wvapp.readFile();
//			
//			System.setProperty("org.eclipse.swt.browser.XULRunnerPath", System.getProperty("user.dir") + System.getProperty("file.separator") + "browser");
//			System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", System.getProperty("user.dir") + System.getProperty("file.separator") + "profile");
//		}
		
		gui = new GUI(OperationMode.APPLICATION_MODE);
		
		System.setProperty("org.eclipse.swt.browser.XULRunnerPath", System.getProperty("user.dir") + System.getProperty("file.separator") + "browser");
		System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", System.getProperty("user.dir") + System.getProperty("file.separator") + "profile");
		
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