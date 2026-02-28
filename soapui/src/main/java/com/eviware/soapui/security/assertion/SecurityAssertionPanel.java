

package com.eviware.soapui.security.assertion;

import com.eviware.soapui.impl.wsdl.panels.teststeps.AssertionsPanel;
import com.eviware.soapui.impl.wsdl.support.HelpUrls;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.model.testsuite.TestAssertion;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Component;

public class SecurityAssertionPanel extends AssertionsPanel {
    public SecurityAssertionPanel(Assertable assertable) {
        super(assertable);
    }

    @Override
    protected void initListAndModel() {
        assertionListModel = new SecurityAssertionListModel();
        assertionList = new JList(assertionListModel);
        assertionList.setToolTipText("Assertions for this security scan.");
        assertionList.setCellRenderer(new SecurityAssertionCellRenderer());
    }

    protected class SecurityAssertionListModel extends AssertionListModel {
        protected void addAssertion(TestAssertion assertion) {
            assertion.addPropertyChangeListener(this);
            items.add(assertion);
        }
    }

    private class SecurityAssertionCellRenderer extends JLabel implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            setEnabled(list.isEnabled());

            TestAssertion assertion = (TestAssertion) value;
            setText(assertion.getLabel());

            if (assertion.isDisabled() && isEnabled()) {
                setEnabled(false);
            }

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setFont(list.getFont());
            setOpaque(true);

            return this;
        }

    }

    public String getHelpUrl() {
        return HelpUrls.SECURITY_ASSERTION_HELP;
    }

}
