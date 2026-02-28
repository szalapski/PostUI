

package com.eviware.soapui.model.tree.nodes.support;

import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.model.support.TestSuiteListenerAdapter;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestSuiteListener;
import com.eviware.soapui.security.SecurityTest;
import com.eviware.soapui.support.UISupport;

/**
 * ModelItem for LoadTests node
 *
 * @author ole.matzura
 */

public class SecurityTestsModelItem extends BaseTestsModelItem {
    private TestSuiteListener listener = new InternalTestSuiteListener();

    public SecurityTestsModelItem(TestCase testCase) {
        super(testCase, createLabel(testCase), UISupport.createImageIcon("/security_tests_group.png"));

        testCase.getTestSuite().addTestSuiteListener(listener);
    }

    private static String createLabel(TestCase testCase) {
        return "Security Tests (" + testCase.getSecurityTestCount() + ")";
    }

    public Settings getSettings() {
        return testCase.getSettings();
    }

    @Override
    public void release() {
        super.release();
        testCase.getTestSuite().removeTestSuiteListener(listener);
    }

    @Override
    public String getName() {
        return createLabel(testCase);
    }

    public void updateLabel() {
        setName(createLabel(testCase));
    }

    public class InternalTestSuiteListener extends TestSuiteListenerAdapter implements TestSuiteListener {
        @Override
        public void securityTestAdded(SecurityTest securityTest) {
            if (securityTest.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void securityTestRemoved(SecurityTest securityTest) {
            if (securityTest.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void testCaseRemoved(TestCase testCase) {
            if (testCase == SecurityTestsModelItem.this.testCase) {
                testCase.getTestSuite().removeTestSuiteListener(listener);
            }
        }
    }
}
