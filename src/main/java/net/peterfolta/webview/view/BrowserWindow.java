/*
 * WebView - A desktop-like web browsing experience
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
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
        browserShell.setImage(wvApp.getIcon());

        browserShell.addShellListener(new ShellListener() {
            public void shellActivated(ShellEvent event) {
            }

            public void shellClosed(ShellEvent event) {
                browserShell.close();
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
        browser.setUrl(wvApp.getUrl());
        browser.addTitleListener(event -> browserShell.setText(event.title));

        browserShell.setSize(1440, 900);
    }

    public void open() {
        browserShell.open();
    }

}