

package com.eviware.soapui.support.xml.actions;

import com.eviware.soapui.support.xml.XmlUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class FormatAction extends AbstractAction {
    private final static Logger log = LogManager.getLogger(FormatAction.class);
    private final RSyntaxTextArea textArea;
    private final String language;

    public FormatAction(RSyntaxTextArea textArea, String language) {
        this(textArea, language, "Format " + language);
    }

    public FormatAction(RSyntaxTextArea textArea, String language, String title) {
        super(title);
        this.textArea = textArea;
        this.language = language;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            textArea.setText(XmlUtils.prettyPrintXml(textArea.getText()));
            textArea.setCaretPosition(0);
        } catch (Exception e1) {
            log.error(e1.getMessage());
        }
    }
}
