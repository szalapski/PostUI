

package com.eviware.x.dialogs;

import java.io.File;

/**
 * @author Lars
 */
public interface XFileDialogs {
    File saveAs(Object action, String title, String extension, String fileType, File defaultFile);

    File saveAs(Object action, String title);

    File saveAsDirectory(Object action, String title, File defaultDirectory);

    File open(Object action, String title, String extension, String fileType, String current);

    File openXML(Object action, String title);

    File openDirectory(Object action, String string, File defaultDirectory);

    File openFileOrDirectory(Object action, String title, File defaultDirectory);
}
