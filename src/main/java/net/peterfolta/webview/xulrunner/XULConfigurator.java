/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            XULConfigurator.java
 * Created:         2015-12-11
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.xulrunner;

import net.peterfolta.webview.main.Application;

public final class XULConfigurator {

    // Suppress Default Constructor for Noninstantiability
    private XULConfigurator() {
        throw new AssertionError();
    }

    public static void setXULRunnerApplicationPath(String xulRunnerApplicationPath) {
        System.setProperty("org.eclipse.swt.browser.XULRunnerPath", xulRunnerApplicationPath);
    }

    public static void setMozillaProfilePath(String profileId) {
        if (profileId == null) {
            throw new NullPointerException();
        }

        String profilePath = System.getProperty("user.home") +
                System.getProperty("file.separator") +
                "." +
                Application.getInstance().getArtifactId() +
                System.getProperty("file.separator") +
                "profiles" +
                System.getProperty("file.separator") +
                profileId;

        System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", profilePath);
    }

}