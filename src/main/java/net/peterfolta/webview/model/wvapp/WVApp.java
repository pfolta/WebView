/*
 * WebView - A desktop client for web applications
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

package net.peterfolta.webview.model.wvapp;

import org.eclipse.swt.graphics.Image;

public class WVApp {

    private String title;
    private boolean usePageTitle;

    private String url;

    private Image icon;

    private Browser browser;
    private Keyboard keyboard;
    private Window window;

    public static class Builder implements net.peterfolta.webview.util.Builder<WVApp> {
        private String title;
        private boolean usePageTitle = true;

        private String url;

        private Image icon;

        private Browser browser;
        private Keyboard keyboard;
        private Window window;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder usePageTitle(boolean usePageTitle) {
            this.usePageTitle = usePageTitle;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder icon(Image icon) {
            this.icon = icon;
            return this;
        }

        public Builder browser(Browser browser) {
            this.browser = browser;
            return this;
        }

        public Builder keyboard(Keyboard keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder window(Window window) {
            this.window = window;
            return this;
        }

        public WVApp build() {
            return new WVApp(this);
        }
    }

    private WVApp(Builder builder) {
        setTitle(builder.title);
        setUsePageTitle(builder.usePageTitle);

        setUrl(builder.url);

        setIcon(builder.icon);

        setBrowser(builder.browser);
        setKeyboard(builder.keyboard);
        setWindow(builder.window);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUsePageTitle() {
        return usePageTitle;
    }

    public void setUsePageTitle(boolean usePageTitle) {
        this.usePageTitle = usePageTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        if (browser == null) {
            throw new NullPointerException();
        }

        this.browser = browser;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        if (keyboard == null) {
            throw new NullPointerException();
        }

        this.keyboard = keyboard;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        if (window == null) {
            throw new NullPointerException();
        }

        this.window = window;
    }

}