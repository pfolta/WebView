/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            BrowserControlListener.java
 * Created:         2015-12-03
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view.keyboard;

import net.peterfolta.webview.model.wvapp.Keyboard;
import net.peterfolta.webview.model.wvapp.WVApp;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public class BrowserControlListener implements KeyListener {

    private Browser browser;

    private WVApp wvApp;
    private Keyboard keyboard;

    public BrowserControlListener(Browser browser, WVApp wvApp) {
        this.browser    = browser;
        this.wvApp      = wvApp;
        this.keyboard   = wvApp.getKeyboard();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyboard.isBackEnabled()) {
            handleGoBack(keyEvent);
        }

        if (keyboard.isForwardEnabled()) {
            handleGoForward(keyEvent);
        }

        if (keyboard.isHomeEnabled()) {
            handleGoHome(keyEvent);
        }

        if (keyboard.isRefreshEnabled()) {
            handleRefresh(keyEvent);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    private void handleGoBack(KeyEvent keyEvent) {
        if (KeyBinding.matchesBackBinding(keyEvent.stateMask, keyEvent.keyCode)) {
            if (browser.isBackEnabled()) {
                browser.back();
            }
        }
    }

    private void handleGoForward(KeyEvent keyEvent) {
        if (KeyBinding.matchesForwardBinding(keyEvent.stateMask, keyEvent.keyCode)) {
            if (browser.isForwardEnabled()) {
                browser.forward();
            }
        }
    }

    private void handleGoHome(KeyEvent keyEvent) {
        if (KeyBinding.matchesHomeBinding(keyEvent.stateMask, keyEvent.keyCode)) {
            browser.setUrl(wvApp.getUrl());
        }
    }

    private void handleRefresh(KeyEvent keyEvent) {
        if (KeyBinding.matchesRefreshBinding(keyEvent.stateMask, keyEvent.keyCode)) {
            browser.refresh();
        }
    }

}