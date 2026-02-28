

package com.eviware.soapui.utils;

import com.eviware.x.dialogs.XFileDialogs;

import java.io.File;

public class StubbedFileDialogs implements XFileDialogs {

    @Override
    public File saveAs(Object action, String title, String extension, String fileType, File defaultFile) {
        return null;
    }

    @Override
    public File saveAs(Object action, String title) {
        return null;
    }

    @Override
    public File saveAsDirectory(Object action, String title, File defaultDirectory) {
        return null;
    }

    @Override
    public File open(Object action, String title, String extension, String fileType, String current) {
        return null;
    }

    @Override
    public File openXML(Object action, String title) {
        return null;
    }

    @Override
    public File openDirectory(Object action, String string, File defaultDirectory) {
        return null;
    }

    @Override
    public File openFileOrDirectory(Object action, String title, File defaultDirectory) {
        return null;
    }
}
