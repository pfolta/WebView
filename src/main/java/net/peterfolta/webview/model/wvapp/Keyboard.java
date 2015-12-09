/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            Keyboard.java
 * Created:         2015-12-09
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.model.wvapp;

public class Keyboard {

    private boolean backEnabled;
    private boolean forwardEnabled;
    private boolean homeEnabled;
    private boolean refreshEnabled;

    public static class Builder implements net.peterfolta.webview.util.Builder<Keyboard> {
        private boolean backEnabled     = true;
        private boolean forwardEnabled  = true;
        private boolean homeEnabled     = true;
        private boolean refreshEnabled  = true;

        public Builder backEnabled(boolean backEnabled) {
            this.backEnabled = backEnabled;
            return this;
        }

        public Builder forwardEnabled(boolean forwardEnabled) {
            this.forwardEnabled = forwardEnabled;
            return this;
        }

        public Builder homeEnabled(boolean homeEnabled) {
            this.homeEnabled = homeEnabled;
            return this;
        }

        public Builder refreshEnabled(boolean refreshEnabled) {
            this.refreshEnabled = refreshEnabled;
            return this;
        }

        public Keyboard build() {
            return new Keyboard(this);
        }
    }

    private Keyboard(Builder builder) {
        setBackEnabled(builder.backEnabled);
        setForwardEnabled(builder.forwardEnabled);
        setHomeEnabled(builder.homeEnabled);
        setRefreshEnabled(builder.refreshEnabled);
    }

    public boolean isBackEnabled() {
        return backEnabled;
    }

    public void setBackEnabled(boolean backEnabled) {
        this.backEnabled = backEnabled;
    }

    public boolean isForwardEnabled() {
        return forwardEnabled;
    }

    public void setForwardEnabled(boolean forwardEnabled) {
        this.forwardEnabled = forwardEnabled;
    }

    public boolean isHomeEnabled() {
        return homeEnabled;
    }

    public void setHomeEnabled(boolean homeEnabled) {
        this.homeEnabled = homeEnabled;
    }

    public boolean isRefreshEnabled() {
        return refreshEnabled;
    }

    public void setRefreshEnabled(boolean refreshEnabled) {
        this.refreshEnabled = refreshEnabled;
    }

}