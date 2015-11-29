/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			WVApp.java
 * Created:			2015/6/16
 * Last modified:	2015/6/16
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.wvapp;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class WVApp {
	
	private String fileName;
	private File file;
	
	private Document xmlDocument;
	private Element rootElement;
	
	private String name;
	private String id;
	private String icon;
	private String url;
	
	public WVApp(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
	}
	
	public void readFile() {
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			xmlDocument = saxBuilder.build(file);
			
			rootElement = xmlDocument.getRootElement();
			
			setName(rootElement.getChild("name").getText());
			setId(rootElement.getChild("id").getText());
			setIcon(rootElement.getChild("icon").getText());
			setUrl(rootElement.getChild("url").getText());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void writeFile() {
		
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}