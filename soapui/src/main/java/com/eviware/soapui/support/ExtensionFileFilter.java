

package com.eviware.soapui.support;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

/**
 * FileFilter for a specified extensions
 */

final public class ExtensionFileFilter extends FileFilter {
    private final String extension;
    private final String description;

    public ExtensionFileFilter(String extension, String description) {
        this.extension = extension.toLowerCase();
        this.description = description;
    }

    public boolean accept(File f) {
        return f.isDirectory() || "*".equals(extension)
                || f.getName().toLowerCase(Locale.getDefault()).endsWith(extension);
    }

    public String getDescription() {
        return description;
    }
}
