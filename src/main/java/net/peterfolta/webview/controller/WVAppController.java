/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            WVAppController.java
 * Created:         2015-11-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.controller;

import net.peterfolta.webview.model.WVApp;

public class WVAppController {

    private String wvAppFile;

    private WVApp wvApp;

    public WVAppController(String wvAppFile) {
        this.wvAppFile = wvAppFile;
    }

    public void read() {
        wvApp = new WVApp(wvAppFile);
    }

    public WVApp getWvApp() {
        return wvApp;
    }

}