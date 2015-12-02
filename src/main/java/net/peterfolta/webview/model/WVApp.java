/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            WVApp.java
 * Created:         2015-06-16
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.model;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.File;

public class WVApp {

    private File file;

    private Document xmlDocument;
    private Element rootElement;

    private String title;
    private Image icon;
    private String url;

    public WVApp(String fileName) {
        this.file = new File(fileName);

        read();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private void read() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            xmlDocument = saxBuilder.build(file);

            rootElement = xmlDocument.getRootElement();

            setTitle(rootElement.getChild("title").getText());

            setIcon(createImageFromBase64(rootElement.getChild("icon").getText()));

            setUrl(rootElement.getChild("url").getText());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private Image createImageFromBase64(String base64) {
        try {
            byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64);
            return new Image(Display.getCurrent(), new ByteArrayInputStream(base64Decoded));
        } catch (Exception exception) {
            return null;
        }
    }

}