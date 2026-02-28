

package com.eviware.soapui.model.tree.nodes.support;

import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.model.support.TestSuiteListenerAdapter;
import com.eviware.soapui.model.testsuite.LoadTest;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestSuiteListener;
import com.eviware.soapui.support.UISupport;

/**
 * ModelItem for LoadTests node
 *
 * @author ole.matzura
 */

public class WsdlLoadTestsModelItem extends BaseTestsModelItem {
    private TestSuiteListener listener = new InternalTestSuiteListener();

    public WsdlLoadTestsModelItem(TestCase testCase) {
        super(testCase, createLabel(testCase), UISupport.createImageIcon("/loadtests.png"));

        testCase.getTestSuite().addTestSuiteListener(listener);
    }

    private static String createLabel(TestCase testCase) {
        return "Load Tests (" + testCase.getLoadTestCount() + ")";
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
        public void loadTestAdded(LoadTest loadTest) {
            if (loadTest.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void loadTestRemoved(LoadTest loadTest) {
            if (loadTest.getTestCase() == testCase) {
                updateLabel();
            }
        }

        @Override
        public void testCaseRemoved(TestCase testCase) {
            if (testCase == WsdlLoadTestsModelItem.this.testCase) {
                testCase.getTestSuite().removeTestSuiteListener(listener);
            }
        }
    }
}
