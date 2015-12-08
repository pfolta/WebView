/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            Window.java
 * Created:         2015-12-05
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.model.wvapp;

public class Window {

    private int x;
    private int y;
    private int width;
    private int height;

    private boolean resizable;
    private boolean maximizable;

    private boolean maximized;

    public static class Builder {
        private int x = 0;
        private int y = 0;
        private int width = 0;
        private int height = 0;

        private boolean resizable = false;
        private boolean maximizable = false;

        private boolean maximized = false;

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder resizable(boolean resizable) {
            this.resizable = resizable;
            return this;
        }

        public Builder maximizable(boolean maximizable) {
            this.maximizable = maximizable;
            return this;
        }

        public Builder maximized(boolean maximized) {
            this.maximized = maximized;
            return this;
        }

        public Window build() {
            return new Window(this);
        }
    }

    private Window(Builder builder) {
        x           = builder.x;
        y           = builder.y;
        width       = builder.width;
        height      = builder.height;
        resizable   = builder.resizable;
        maximizable = builder.maximizable;
        maximized   = builder.maximized;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isMaximizable() {
        return maximizable;
    }

    public boolean isMaximized() {
        return maximized;
    }

}