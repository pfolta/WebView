/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 * 
 * File:            Main.java
 * Created:         2014-03-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            new WebViewDriver(args[0]);
        }
    }

}