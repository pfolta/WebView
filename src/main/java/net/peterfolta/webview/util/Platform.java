/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            Platform.java
 * Created:         2015-12-03
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.util;

public final class Platform {

    // Suppress default constructor for noninstantiability
    private Platform() {
        throw new AssertionError();
    }

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().startsWith("mac");
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

}