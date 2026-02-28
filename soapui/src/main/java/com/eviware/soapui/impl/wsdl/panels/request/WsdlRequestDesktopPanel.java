

package com.eviware.soapui.impl.wsdl.panels.request;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.actions.request.AddRequestAsMockResponseStepAction;
import com.eviware.soapui.impl.wsdl.actions.request.AddRequestToTestCaseAction;
import com.eviware.soapui.impl.wsdl.support.HelpUrls;
import com.eviware.soapui.support.action.swing.SwingActionDelegate;
import com.eviware.soapui.support.components.JXToolBar;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * DesktopPanel for standard WsdlRequests
 *
 * @author ole.matzura
 */

public class WsdlRequestDesktopPanel extends AbstractWsdlRequestDesktopPanel<WsdlRequest, WsdlRequest> {
    private JButton addToTestCaseButton;
    private JButton addAsMockResponseStepToTestCaseButton;

    public WsdlRequestDesktopPanel(WsdlRequest request) {
        super(request, request);
    }

    @Override
    protected void init(WsdlRequest request) {
        addToTestCaseButton = createActionButton(SwingActionDelegate.createDelegate(
                AddRequestToTestCaseAction.SOAPUI_ACTION_ID, getRequest(), null, "/add_to_test_case.png"), true);

        super.init(request);
    }

    protected String getHelpUrl() {
        return HelpUrls.REQUESTEDITOR_HELP_URL;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        addToTestCaseButton.setEnabled(enabled);
        addAsMockResponseStepToTestCaseButton.setEnabled(enabled);
    }

    protected void insertButtons(JXToolBar toolbar) {
        toolbar.add(addToTestCaseButton);

        super.insertButtons(toolbar);

        AbstractAction delegate = SwingActionDelegate.createDelegate(
                AddRequestAsMockResponseStepAction.SOAPUI_ACTION_ID, getRequest(), null, "/addAsMockResponseStep.gif");
        addAsMockResponseStepToTestCaseButton = createActionButton(delegate, true);

        toolbar.add(addAsMockResponseStepToTestCaseButton);
    }
}
