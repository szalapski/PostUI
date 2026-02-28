

package com.eviware.soapui.support.xml.actions;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves the XML of a JXmlTextArea to a file
 *
 * @author Ole.Matzura
 */

public class SaveXmlTextAreaAction extends AbstractAction {
    private final RSyntaxTextArea textArea;
    private String dialogTitle;
    private static final Logger log = LogManager.getLogger(SaveXmlTextAreaAction.class);

    public SaveXmlTextAreaAction(RSyntaxTextArea editArea, String dialogTitle) {
        super("Save as..");
        this.textArea = editArea;
        this.dialogTitle = dialogTitle;
        if (UISupport.isMac()) {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("menu S"));
        } else {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("ctrl S"));
        }
    }

    public void actionPerformed(ActionEvent e) {
        File file = UISupport.getFileDialogs().saveAs(this, dialogTitle, ".xml", "XML Files (*.xml)", null);
        if (file == null) {
            return;
        }

        FileWriter writer = null;

        try {
            try {
                // XmlObject xml = XmlObject.Factory.parse( textArea.getText() );
                XmlObject xml = XmlUtils.createXmlObject(textArea.getText());
                xml.save(file);
            } catch (XmlException e1) {
                writer = new FileWriter(file);
                writer.write(textArea.getText());
                writer.close();
            }

            log.info("XML written to [" + file.getAbsolutePath() + "]");
        } catch (IOException e1) {
            UISupport.showErrorMessage("Error saving xml to file: " + e1.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    SoapUI.logError(e1);
                }
            }
        }
    }
}
