

package com.eviware.soapui.impl.wsdl.panels.support;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.monitor.support.TestMonitorListenerAdapter;
import com.eviware.soapui.security.SecurityTestRunner;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.List;

/**
 * ComponentEnabler for disabling components during TestCase runs
 *
 * @author Ole.Matzura
 */

public class TestRunComponentEnabler extends TestMonitorListenerAdapter {
    private final List<JComponent> components = new ArrayList<>();
    private final List<Boolean> states = new ArrayList<>();
    private final TestCase testCase;

    public TestRunComponentEnabler(TestCase testCase) {
        this.testCase = testCase;

        SoapUI.getTestMonitor().addTestMonitorListener(this);
    }

    public void release() {
        SoapUI.getTestMonitor().removeTestMonitorListener(this);
    }

    public void loadTestStarted(LoadTestRunner runner) {
        disable();
    }

    public void securityTestStarted(SecurityTestRunner runner) {
        disable();
    }

    private void disable() {
        if (states.isEmpty()) {
            for (JComponent component : components) {
                states.add(component.isEnabled());
                component.setEnabled(false);
            }
        }
    }

    private void enable() {
        if (!states.isEmpty()) {
            for (int c = 0; c < components.size(); c++) {
                JComponent component = components.get(c);
                component.setEnabled(states.get(c));
            }

            states.clear();
        }
    }

    public void loadTestFinished(LoadTestRunner runner) {
        if (!SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            enable();
        }
    }

    public void securityTestFinished(SecurityTestRunner runner) {
        if (!SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            enable();
        }
    }

    public void testCaseStarted(TestCaseRunner runner) {
        disable();
    }

    public void testCaseFinished(TestCaseRunner runner) {
        if (!SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            enable();
        }
    }

    public void add(JComponent component) {
        components.add(component);

        if (SoapUI.getTestMonitor().hasRunningTest(testCase)) {
            states.add(component.isEnabled());
            component.setEnabled(false);
        }
    }
}
