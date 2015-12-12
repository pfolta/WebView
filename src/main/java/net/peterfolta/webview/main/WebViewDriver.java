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
import net.peterfolta.webview.xulrunner.XULConfigurator;

import java.io.File;
import java.net.URISyntaxException;

public class WebViewDriver {

    private WVAppController wvAppController;
    private GUIController guiController;

    public WebViewDriver(String wvAppFile) {
        setXULRunnerApplicationPath();

        wvAppController = new WVAppController(wvAppFile);
        wvAppController.read();

        guiController = new GUIController();
        guiController.createBrowserWindow(wvAppController.getWvApp());
    }

    private void setXULRunnerApplicationPath() {
        try {
            File applicationLocation = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String xulRunnerPath;

            while (!applicationLocation.isDirectory()) {
                applicationLocation = applicationLocation.getParentFile();
            }

            xulRunnerPath = applicationLocation.getPath() + System.getProperty("file.separator") + "xulrunner";

            XULConfigurator.setXULRunnerApplicationPath(xulRunnerPath);
        } catch (URISyntaxException exception) {
            Main.exitWithException("An error occurred while trying to locate the XULRunner Runtime.", exception);
        }
    }

}