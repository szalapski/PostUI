

package com.eviware.soapui.support.editor.inspectors.attachments;

import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;

/**
 * TableModel for Attachment tables
 *
 * @author ole.matzura
 */

public interface AttachmentTableModel extends TableModel {
    public abstract void addFile(File file, boolean cacheInRequest) throws IOException;
}
