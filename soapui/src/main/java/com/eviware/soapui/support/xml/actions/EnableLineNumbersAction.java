

package com.eviware.soapui.support.xml.actions;

import com.eviware.soapui.support.UISupport;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class EnableLineNumbersAction extends AbstractAction {
    private final RTextScrollPane editorScrollPane;

    public EnableLineNumbersAction(RTextScrollPane editorScrollPane, String title) {
        super(title);
        this.editorScrollPane = editorScrollPane;
        if (UISupport.isMac()) {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("ctrl L"));
        } else {
            putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("alt L"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editorScrollPane.setLineNumbersEnabled(!editorScrollPane.getLineNumbersEnabled());
    }

}
