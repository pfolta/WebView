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
    private boolean minimizable;
    private boolean maximizable;

    private boolean maximized;

    public static class Builder implements net.peterfolta.webview.util.Builder<Window> {
        private int x = 0;
        private int y = 0;
        private int width = 800;
        private int height = 600;

        private boolean resizable = true;
        private boolean minimizable = true;
        private boolean maximizable = true;

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

        public Builder minimizable(boolean minimizable) {
            this.minimizable = minimizable;
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
        setX(builder.x);
        setY(builder.y);
        setWidth(builder.width);
        setHeight(builder.height);

        setResizable(builder.resizable);
        setMinimizable(builder.minimizable);
        setMaximizable(builder.maximizable);

        setMaximized(builder.maximized);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException(x + " < 0");
        }

        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException(y + " < 0");
        }

        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException(width + " < 0");
        }

        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException(height + " < 0");
        }

        this.height = height;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isMinimizable() {
        return minimizable;
    }

    public void setMinimizable(boolean minimizable) {
        this.minimizable = minimizable;
    }

    public boolean isMaximizable() {
        return maximizable;
    }

    public void setMaximizable(boolean maximizable) {
        this.maximizable = maximizable;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized = maximized;
    }

}