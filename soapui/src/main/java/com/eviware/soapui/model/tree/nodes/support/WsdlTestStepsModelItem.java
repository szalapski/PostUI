

package com.eviware.soapui.model.tree.nodes.support;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.model.support.TestSuiteListenerAdapter;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestSuiteListener;
import com.eviware.soapui.support.UISupport;

/**
 * ModelItem for TestSteps node
 *
 * @author ole.matzura
 */

public class WsdlTestStepsModelItem extends BaseTestsModelItem {
    private TestSuiteListener listener = new InternalTestSuiteListener();

    public WsdlTestStepsModelItem(TestCase testCase) {
        super(testCase, createLabel(testCase), UISupport.createImageIcon("/teststeps.png"));

        testCase.getTestSuite().addTestSuiteListener(listener);
    }

    private static String createLabel(TestCase testCase) {
        return "Test Steps (" + testCase.getTestStepCount() + ")";
    }

    public Settings getSettings() {
        return testCase.getSettings();
    }

    @Override
    public String getName() {
        return createLabel(testCase);
    }

    public WsdlTestCase getTestCase() {
        return (WsdlTestCase) testCase;
    }

    @Override
    public void release() {
        super.release();
        testCase.getTestSuite().removeTestSuiteListener(listener);
    }

    public void updateLabel() {
        setName(createLabel(testCase));
    }

    public class InternalTestSuiteListener extends TestSuiteListenerAdapter implements TestSuiteListener {
        @Override
        public void testStepAdded(TestStep testStep, int index) {
            if (testStep.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void testStepRemoved(TestStep testStep, int index) {
            if (testStep.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void testCaseRemoved(TestCase testCase) {
            if (testCase == WsdlTestStepsModelItem.this.testCase) {
                testCase.getTestSuite().removeTestSuiteListener(listener);
            }
        }
    }

}
