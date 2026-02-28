

package com.eviware.soapui.impl.wsdl.panels.testcase.actions;

import com.eviware.soapui.impl.support.http.HttpRequestTestStep;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.TestRequest;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Action for setting the endpoint for all requests in a testcase
 *
 * @author Ole.Matzura
 */

public class SetEndpointAction extends AbstractAction {
    private static final String USE_CURRENT = "- use current -";
    private final WsdlTestCase testCase;

    public SetEndpointAction(WsdlTestCase testCase) {
        this.testCase = testCase;
        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/set_endpoint.gif"));
        putValue(Action.SHORT_DESCRIPTION, "Sets the endpoint for all requests in this testcase");
    }

    public void actionPerformed(ActionEvent e) {
        Set<String> endpointSet = new TreeSet<>();
        Set<String> currentEndpointSet = new HashSet<>();

        endpointSet.add(USE_CURRENT);

        for (int c = 0; c < testCase.getTestStepCount(); c++) {
            TestStep step = testCase.getTestStepAt(c);
            if (step instanceof HttpRequestTestStep) {
                HttpRequestTestStep requestStep = (HttpRequestTestStep) step;
                Operation operation = requestStep.getTestRequest().getOperation();
                if (operation != null) {
                    String[] endpoints = operation.getInterface().getEndpoints();
                    for (int i = 0; i < endpoints.length; i++) {
                        endpointSet.add(endpoints[i]);
                    }
                }
                currentEndpointSet.add(requestStep.getTestRequest().getEndpoint());
            }
        }

        String selected = (String) UISupport.prompt("Select endpoint to set for all requests", "Set Endpoint",
                endpointSet.toArray(), currentEndpointSet.size() == 1 ? currentEndpointSet.iterator().next() : USE_CURRENT);

        if (selected == null || selected.equals(USE_CURRENT)) {
            return;
        }

        int cnt = 0;

        for (int c = 0; c < testCase.getTestStepCount(); c++) {
            TestStep step = testCase.getTestStepAt(c);
            if (step instanceof HttpRequestTestStep) {
                HttpRequestTestStep requestStep = (HttpRequestTestStep) step;
                TestRequest testRequest = requestStep.getTestRequest();

                if (testRequest.getEndpoint() == null || !testRequest.getEndpoint().equals(selected)) {
                    testRequest.setEndpoint(selected);
                    cnt++;
                }
            }
        }

        UISupport.showInfoMessage("Changed endpoint to [" + selected + "] for " + cnt + " requests");
    }
}
