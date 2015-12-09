/*
 * WebView - A desktop client for web applications
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

import net.peterfolta.webview.model.wvapp.Browser;
import net.peterfolta.webview.model.wvapp.Keyboard;
import net.peterfolta.webview.model.wvapp.WVApp;
import net.peterfolta.webview.model.wvapp.Window;
import net.peterfolta.webview.util.ImageTools;
import org.eclipse.swt.graphics.Image;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;

public class WVAppController {

    private String wvAppFile;

    private WVApp wvApp;

    public WVAppController(String wvAppFile) {
        this.wvAppFile = wvAppFile;
    }

    public void read() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document xmlDocument = null;
        try {
            xmlDocument = saxBuilder.build(wvAppFile);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element rootElement         = xmlDocument.getRootElement();

        Element browserElement      = rootElement.getChild("browser");
        boolean javascriptEnabled   = Boolean.valueOf(browserElement.getChild("javascriptEnabled").getValue());
        boolean openExternalLinks   = Boolean.valueOf(browserElement.getChild("openExternalLinks").getValue());
        Browser browser             = new Browser.Builder().javascriptEnabled(javascriptEnabled).openExternalLinks(openExternalLinks).build();

        Element keyboardElement     = rootElement.getChild("keyboard");
        boolean backEnabled         = Boolean.valueOf(keyboardElement.getChild("backEnabled").getValue());
        boolean forwardEnabled      = Boolean.valueOf(keyboardElement.getChild("forwardEnabled").getValue());
        boolean homeEnabled         = Boolean.valueOf(keyboardElement.getChild("homeEnabled").getValue());
        boolean refreshEnabled      = Boolean.valueOf(keyboardElement.getChild("refreshEnabled").getValue());
        Keyboard keyboard           = new Keyboard.Builder().backEnabled(backEnabled).forwardEnabled(forwardEnabled).homeEnabled(homeEnabled).refreshEnabled(refreshEnabled).build();

        Element windowElement       = rootElement.getChild("window");
        int x                       = Integer.valueOf(windowElement.getChild("x").getValue());
        int y                       = Integer.valueOf(windowElement.getChild("y").getValue());
        int width                   = Integer.valueOf(windowElement.getChild("width").getValue());
        int height                  = Integer.valueOf(windowElement.getChild("height").getValue());
        boolean resizable           = Boolean.valueOf(windowElement.getChild("resizable").getValue());
        boolean minimizable         = Boolean.valueOf(windowElement.getChild("minimizable").getValue());
        boolean maximizable         = Boolean.valueOf(windowElement.getChild("maximizable").getValue());
        boolean maximized           = Boolean.valueOf(windowElement.getChild("maximized").getValue());
        Window window               = new Window.Builder().x(x).y(y).width(width).height(height).resizable(resizable).minimizable(minimizable).maximizable(maximizable).maximized(maximized).build();

        String title                = rootElement.getChild("title").getValue();
        boolean usePageTitle        = Boolean.valueOf(rootElement.getChild("title").getAttribute("usePageTitle").getValue());
        String url                  = rootElement.getChild("url").getValue();
        Image icon                  = ImageTools.createImageFromBase64(rootElement.getChild("icon").getText());

        wvApp                       = new WVApp.Builder().title(title).usePageTitle(usePageTitle).url(url).icon(icon).browser(browser).keyboard(keyboard).window(window).build();
    }

    public WVApp getWvApp() {
        return wvApp;
    }

}