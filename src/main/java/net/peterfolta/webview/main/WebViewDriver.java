/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            WebViewDriver.java
 * Created:         2015-11-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

import net.peterfolta.webview.controller.GUIController;
import net.peterfolta.webview.controller.WVAppController;

public class WebViewDriver {

    private WVAppController wvAppController;
    private GUIController guiController;

    public WebViewDriver(String wvAppFile) {
        String XULRunnerPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "target" + System.getProperty("file.separator") + "xulrunner";

        System.setProperty("org.eclipse.swt.browser.XULRunnerPath", XULRunnerPath);
        System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", System.getProperty("user.dir") + System.getProperty("file.separator") + "profile");

        wvAppController = new WVAppController(wvAppFile);
        wvAppController.read();

        guiController = new GUIController();
        guiController.createBrowserWindow(wvAppController.getWvApp());
    }

}