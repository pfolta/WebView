/*
 * WebView - A desktop client for web applications
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 *
 * Project:         WebView
 * Version:         0.0.1
 * Website:
 *
 * File:            ImageTools.java
 * Created:         2015-12-09
 * Author:          Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.util;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;

public final class ImageTools {

    // Suppress default constructor for noninstantiability
    private ImageTools() {
        throw new AssertionError();
    }

    public static Image createImageFromBase64(String base64) {
        byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64);
        return new Image(Display.getCurrent(), new ByteArrayInputStream(base64Decoded));
    }

}
