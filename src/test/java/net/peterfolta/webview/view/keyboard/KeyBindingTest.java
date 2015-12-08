/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            KeyboardBindingTest.java
 * Created:         2015-12-03
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view.keyboard;

import net.peterfolta.webview.util.Platform;
import org.eclipse.swt.SWT;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KeyBindingTest {

    @Test
    public void whenAltLeftArrowOrCommandLeftArrowOnMacIsPressedItShouldReturnTrue() {
        int stateMask = 0;
        int keyCode   = 0x1000003;

        if (Platform.isWindows() || Platform.isLinux()) {
            stateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            stateMask = SWT.COMMAND;
        }

        assertTrue(KeyBinding.matchesBackBinding(stateMask, keyCode));
    }

    @Test
    public void whenAltRightArrowOrCommandRightArrowOnMacIsPressedItShouldReturnTrue() {
        int stateMask = 0;
        int keyCode   = 0x1000004;

        if (Platform.isWindows() || Platform.isLinux()) {
            stateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            stateMask = SWT.COMMAND;
        }

        assertTrue(KeyBinding.matchesForwardBinding(stateMask, keyCode));
    }

    @Test
    public void whenAltHomeOrCommandHomeOnMacIsPressedItShouldReturnTrue() {
        int stateMask = 0;
        int keyCode   = SWT.HOME;

        if (Platform.isWindows() || Platform.isLinux()) {
            stateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            stateMask = SWT.COMMAND;
        }

        assertTrue(KeyBinding.matchesHomeBinding(stateMask, keyCode));
    }

    @Test
    public void whenF5OrCommandROnMacIsPressedItShouldReturnTrue() {
        int stateMask = 0;
        int keyCode   = 0;

        if (Platform.isWindows() || Platform.isLinux()) {
            keyCode   = SWT.F5;
        }

        if (Platform.isMac()) {
            stateMask = SWT.COMMAND;
            keyCode   = 'R';
        }

        assertTrue(KeyBinding.matchesRefreshBinding(stateMask, keyCode));
    }

}