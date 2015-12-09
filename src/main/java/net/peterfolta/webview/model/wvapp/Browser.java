/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            Browser.java
 * Created:         2015-12-09
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.model.wvapp;

public class Browser {

    private boolean javascriptEnabled;
    private boolean openExternalLinks;

    public static class Builder implements net.peterfolta.webview.util.Builder<Browser> {
        private boolean javascriptEnabled = true;
        private boolean openExternalLinks = true;

        public Builder javascriptEnabled(boolean javascriptEnabled) {
            this.javascriptEnabled = javascriptEnabled;
            return this;
        }

        public Builder openExternalLinks(boolean openExternalLinks) {
            this.openExternalLinks = openExternalLinks;
            return this;
        }

        public Browser build() {
            return new Browser(this);
        }
    }

    private Browser(Builder builder) {
        setJavascriptEnabled(builder.javascriptEnabled);
        setOpenExternalLinks(builder.openExternalLinks);
    }

    public boolean isJavascriptEnabled() {
        return javascriptEnabled;
    }

    public void setJavascriptEnabled(boolean javascriptEnabled) {
        this.javascriptEnabled = javascriptEnabled;
    }

    public boolean isOpenExternalLinks() {
        return openExternalLinks;
    }

    public void setOpenExternalLinks(boolean openExternalLinks) {
        this.openExternalLinks = openExternalLinks;
    }

}