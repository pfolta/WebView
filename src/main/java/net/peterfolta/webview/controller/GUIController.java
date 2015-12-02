/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            GUIController.java
 * Created:         2015-11-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.controller;

import net.peterfolta.webview.model.WVApp;
import net.peterfolta.webview.view.BrowserWindow;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GUIController {

    private Display display;

    private BrowserWindow browserWindow;

    public GUIController() {
        display = Display.getDefault();
    }

    public void createBrowserWindow(WVApp wvApp) {
        browserWindow = new BrowserWindow(display, wvApp);

        Shell browserShell = browserWindow.getShell();
        browserShell.open();

        while (!browserShell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

}