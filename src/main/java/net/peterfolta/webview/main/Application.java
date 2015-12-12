/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            Application.java
 * Created:         2015-12-12
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Application {

    private static Application instance;

    private Properties applicationProperties;

    private Application() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/application.properties");

            if (inputStream == null) {
                throw new IOException("File does not exist.");
            }

            applicationProperties = new Properties();
            applicationProperties.load(inputStream);

            inputStream.close();
        } catch (IOException exception) {
            Main.exitWithException("An error occurred while trying to load application.properties.", exception);
        }
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }

        return instance;
    }

    public String getGroupId() {
        return applicationProperties.getProperty("application.groupId");
    }

    public String getArtifactId() {
        return applicationProperties.getProperty("application.artifactId");
    }

    public String getName() {
        return applicationProperties.getProperty("application.name");
    }

    public String getVersion() {
        return applicationProperties.getProperty("application.version");
    }

    public String getCopyright() {
        return applicationProperties.getProperty("application.copyright");
    }

    public String getCompanyName() {
        return applicationProperties.getProperty("application.companyName");
    }

    public String getBuildPlatform() {
        return applicationProperties.getProperty("build.platform");
    }

    public String getBuildOsName() {
        return applicationProperties.getProperty("build.osName");
    }

    public String getBuildArch() {
        return applicationProperties.getProperty("build.arch");
    }

}