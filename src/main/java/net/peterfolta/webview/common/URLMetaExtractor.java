/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			SetupWindow.java
 * Created:			2015/7/28
 * Last modified:	2015/7/28
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLMetaExtractor {
	
	private String url;
	
	public URLMetaExtractor(String url) {
		this.url = url;
	}
	
	public String getPageTitle() throws IOException, IllegalArgumentException {
		Pattern TITLE_TAG = Pattern.compile("\\<title>(.*)\\</title>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		
		URL url = new URL(this.url);
		URLConnection conn = url.openConnection();
		
		InputStream in = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int n = 0, totalRead = 0;
        char[] buf = new char[1024];
        StringBuilder content = new StringBuilder();

        // read until EOF or first 8192 characters
        while (totalRead < 32768 && (n = reader.read(buf, 0, buf.length)) != -1) {
            content.append(buf, 0, n);
            totalRead += n;
        }
        reader.close();

        // extract the title
        Matcher matcher = TITLE_TAG.matcher(content);
        if (matcher.find()) {
            /* replace any occurrences of whitespace (which may
             * include line feeds and other uglies) as well
             * as HTML brackets with a space */
            return matcher.group(1).replaceAll("[\\s\\<>]+", " ").trim();
        }
        
        return null;
	}
	
	public String getPageFavicon() {
		String url = "http://www.google.com/s2/favicons?domain=" + this.url;
		
		return url;
	}
	
}