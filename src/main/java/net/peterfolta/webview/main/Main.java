/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 * 
 * File:            Main.java
 * Created:         2014-03-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

import net.peterfolta.webview.view.common.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            new WebViewDriver(args[0]);
        }
    }

    public static void exitWithException(String errorMessage, Exception exception) {
        // Format Error Message to include Details
        errorMessage += System.lineSeparator();
        errorMessage += System.lineSeparator();
        errorMessage += exception.getClass().getName() + ": " + exception.getMessage();

        // Print Stack Trace
        exception.printStackTrace();

        // Display GUI Error Message
        new MessageBox(new Shell(), errorMessage, "WebView", SWT.ICON_ERROR, SWT.OK);

        Main.exit(-1);
    }

    public static void exit(int status) {
        System.exit(status);
    }

}