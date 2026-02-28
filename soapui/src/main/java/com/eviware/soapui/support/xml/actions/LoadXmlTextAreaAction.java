

package com.eviware.soapui.support.xml.actions;

import com.eviware.soapui.support.Tools;
import com.eviware.soapui.support.UISupport;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Loads XML into a JXmlTextArea from a file
 *
 * @author Ole.Matzura
 */

public class LoadXmlTextAreaAction extends AbstractAction {
    private final RSyntaxTextArea textArea;
    private String dialogTitle;

    public LoadXmlTextAreaAction(RSyntaxTextArea textArea, String dialogTitle) {
        super("Load from..");
        this.textArea = textArea;
        this.dialogTitle = dialogTitle;
        if (UISupport.isMac()) {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("meta L"));
        } else {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("ctrl L"));
        }

    }

    public void actionPerformed(ActionEvent e) {
        File file = UISupport.getFileDialogs().open(this, dialogTitle, ".xml", "XML Files (*.xml)", null);
        if (file == null) {
            return;
        }

        try {
            textArea.setText(Tools.readAll(new FileInputStream(file), 0).toString());
        } catch (IOException e1) {
            UISupport.showErrorMessage("Error loading xml from file: " + e1.getMessage());
        }
    }
}
