/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            BrowserWindow.java
 * Created:         2014-03-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view;

import net.peterfolta.webview.model.WVApp;
import net.peterfolta.webview.view.keyboard.BrowserControlListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserWindow {

    private Display display;
    private WVApp wvApp;

    private Shell browserShell;
    private Browser browser;

    public BrowserWindow(Display display, WVApp wvApp) {
        this.display = display;
        this.wvApp = wvApp;

        browserShell = new Shell(display, SWT.TITLE | SWT.MIN | SWT.RESIZE | SWT.MAX | SWT.CLOSE);

        browserShell.setText(wvApp.getTitle());
        browserShell.setImage(wvApp.getIcon());

        browserShell.setLayout(new FillLayout());

        browser = new Browser(browserShell, SWT.MOZILLA);
        browser.setUrl(wvApp.getUrl());
        browser.addTitleListener(event -> browserShell.setText(event.title));
        browser.addKeyListener(new BrowserControlListener(browser, wvApp));

        // Open external links inside the application
        browser.addOpenWindowListener(event -> event.browser = browser);

        browserShell.setSize(1440, 900);
    }

    public Shell getShell() {
        return browserShell;
    }

}