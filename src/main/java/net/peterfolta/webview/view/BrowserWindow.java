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

import net.peterfolta.webview.model.wvapp.Browser;
import net.peterfolta.webview.model.wvapp.WVApp;
import net.peterfolta.webview.model.wvapp.Window;
import net.peterfolta.webview.view.keyboard.BrowserControlListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserWindow {

    private Display display;

    private WVApp wvApp;
    private Browser browser;
    private Window window;

    private Shell browserShell;
    private org.eclipse.swt.browser.Browser browserComponent;

    public BrowserWindow(Display display, WVApp wvApp) {
        this.display    = display;
        this.wvApp      = wvApp;
        this.browser    = this.wvApp.getBrowser();
        this.window     = this.wvApp.getWindow();

        int browserShellModifiers = SWT.TITLE | SWT.CLOSE;

        if (window.isResizable()) {
            browserShellModifiers |= SWT.RESIZE;
        }

        if (window.isMinimizable()) {
            browserShellModifiers |= SWT.MIN;
        }

        if (window.isMaximizable()) {
            browserShellModifiers |= SWT.MAX;
        }

        browserShell = new Shell(this.display, browserShellModifiers);

        browserShell.setLocation(window.getX(), window.getY());
        browserShell.setSize(window.getWidth(), window.getHeight());

        browserShell.setMaximized(window.isMaximized());

        browserShell.setText(wvApp.getTitle());
        browserShell.setImage(wvApp.getIcon());

        browserShell.setLayout(new FillLayout());

        browserComponent = new org.eclipse.swt.browser.Browser(browserShell, SWT.MOZILLA);
        browserComponent.setUrl(wvApp.getUrl());

        browserComponent.setJavascriptEnabled(browser.isJavascriptEnabled());

        if (wvApp.isUsePageTitle()) {
            browserComponent.addTitleListener(event -> browserShell.setText(event.title));
        }

        browserComponent.addKeyListener(new BrowserControlListener(browserComponent, wvApp));

        if (browser.isOpenExternalLinks()) {
            // Open external links inside the application
            browserComponent.addOpenWindowListener(event -> event.browser = browserComponent);
        }
    }

    public Shell getShell() {
        return browserShell;
    }

}