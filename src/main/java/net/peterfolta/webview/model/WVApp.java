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

    private String fileName;
    private File file;

    private Document xmlDocument;
    private Element rootElement;

    private String name;
    private String id;
    private Image icon;
    private String url;

    public WVApp(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);

        read();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

            setName(rootElement.getChild("name").getText());
            setId(rootElement.getChild("id").getText());

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