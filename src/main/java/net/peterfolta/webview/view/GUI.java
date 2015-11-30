/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            GUI.java
 * Created:         2014-03-30
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view;

import net.peterfolta.webview.enums.OperationMode;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GUI {

    private OperationMode opMode;

    private Display display;

    public GUI(OperationMode opMode) {
        this.opMode = opMode;

        this.display = Display.getDefault();
    }

    public Display getDisplay() {
        return this.display;
    }

    public static void centerShellOnPrimaryMonitor(Shell shell) {
        int monitorWidth = Display.getCurrent().getPrimaryMonitor().getBounds().width;
        int monitorHeight = Display.getCurrent().getPrimaryMonitor().getBounds().height;

        int shellWidth = shell.getSize().x;
        int shellHeight = shell.getSize().y;

        int shellX = (monitorWidth - shellWidth) / 2;
        int shellY = (monitorHeight - shellHeight) / 2;

        shell.setLocation(shellX, shellY);
    }

    public static void centerShellOnParent(Shell shell, Shell parent) {
        int parentX = parent.getBounds().x;
        int parentY = parent.getBounds().y;
        int parentWidth = parent.getBounds().width;
        int parentHeight = parent.getBounds().height;

        int shellWidth = shell.getSize().x;
        int shellHeight = shell.getSize().y;

        int shellX = parentX + (parentWidth - shellWidth) / 2;
        int shellY = parentY + (parentHeight - shellHeight) / 2;

        shell.setLocation(shellX, shellY);
    }

    public void die() {
        display.dispose();
    }

}