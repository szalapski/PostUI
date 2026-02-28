

package com.eviware.soapui.impl.wsdl.teststeps.actions;

import com.eviware.soapui.impl.wsdl.panels.assertions.AddAssertionPanel;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.TestAssertionRegistry;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;

/**
 * Adds a WsdlAssertion to a WsdlTestRequest
 *
 * @author Ole.Matzura
 */

public class AddAssertionAction extends AbstractAction {
    private final Assertable assertable;
    private AddAssertionPanel addAssertionPanel;

    public AddAssertionAction(Assertable assertable) {
        super("Add Assertion");
        this.assertable = assertable;

        putValue(Action.SHORT_DESCRIPTION, "Adds an assertion to this item");
        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/add.png"));
    }

    public void actionPerformed(ActionEvent e) {
        String[] assertions = TestAssertionRegistry.getInstance().getAvailableAssertionNames(assertable);

        if (assertions == null || assertions.length == 0) {
            UISupport.showErrorMessage("No assertions available for this message");
            return;
        }

        addAssertionPanel = new AddAssertionPanel(assertable);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                addAssertionPanel.setVisible(true);
            }
        });

    }

    public void release() {
        if (addAssertionPanel != null) {
            addAssertionPanel.release();
        }
    }
}
