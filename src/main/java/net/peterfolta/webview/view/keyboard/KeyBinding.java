/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            KeyboardBinding.java
 * Created:         2015-12-03
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.view.keyboard;

import net.peterfolta.webview.util.Platform;
import org.eclipse.swt.SWT;

public final class KeyBinding {

    // Prevent instantiation
    private KeyBinding() {
    }

    /**
     * Checks whether a given key combination matches the "Go Back" event.
     *
     * On Windows and Linux:                    ALT + Left Arrow
     * On Mac:                                  COMMAND + Left Arrow
     *
     * @param   givenStateMask                  The Key Combination Modifier
     * @param   givenKeyCode                    The Key Combination Code
     * @return                                  true if matches, false otherwise
     * @see     org.eclipse.swt.events.KeyEvent
     */
    public static boolean matchesBackBinding(int givenStateMask, int givenKeyCode) {
        int requiredStateMask = 0;
        int requiredKeyCode   = 0x1000003;

        if (Platform.isWindows() || Platform.isLinux()) {
            requiredStateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            requiredStateMask = SWT.COMMAND;
        }

        return ((requiredStateMask + requiredKeyCode) == (givenStateMask + givenKeyCode));
    }

    /**
     * Checks whether a given key combination matches the "Go Forward" event.
     *
     * On Windows and Linux:                    ALT + Right Arrow
     * On Mac:                                  COMMAND + Right Arrow
     *
     * @param   givenStateMask                  The Key Combination Modifier
     * @param   givenKeyCode                    The Key Combination Code
     * @return                                  true if matches, false otherwise
     * @see     org.eclipse.swt.events.KeyEvent
     */
    public static boolean matchesForwardBinding(int givenStateMask, int givenKeyCode) {
        int requiredStateMask = 0;
        int requiredKeyCode   = 0x1000004;

        if (Platform.isWindows() || Platform.isLinux()) {
            requiredStateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            requiredStateMask = SWT.COMMAND;
        }

        return ((requiredStateMask + requiredKeyCode) == (givenStateMask + givenKeyCode));
    }

    /**
     * Checks whether a given key combination matches the "Go Home" event.
     *
     * On Windows and Linux:                    ALT + Home
     * On Mac:                                  COMMAND + Home
     *
     * @param   givenStateMask                  The Key Combination Modifier
     * @param   givenKeyCode                    The Key Combination Code
     * @return                                  true if matches, false otherwise
     * @see     org.eclipse.swt.events.KeyEvent
     */
    public static boolean matchesHomeBinding(int givenStateMask, int givenKeyCode) {
        int requiredStateMask = 0;
        int requiredKeyCode   = SWT.HOME;

        if (Platform.isWindows() || Platform.isLinux()) {
            requiredStateMask = SWT.ALT;
        }

        if (Platform.isMac()) {
            requiredStateMask = SWT.COMMAND;
        }

        return ((requiredStateMask + requiredKeyCode) == (givenStateMask + givenKeyCode));
    }

}