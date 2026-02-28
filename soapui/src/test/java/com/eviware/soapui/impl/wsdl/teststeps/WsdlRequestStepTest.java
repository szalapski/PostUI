

package com.eviware.soapui.impl.wsdl.teststeps;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.panels.support.MockTestRunContext;
import com.eviware.soapui.impl.wsdl.panels.support.MockTestRunner;
import com.eviware.soapui.model.testsuite.TestStepResult;
import com.eviware.soapui.model.testsuite.TestSuite;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class WsdlRequestStepTest {

    @Test
    public void executesAndReturnsResult() throws Exception {
        File sampleProjectFile = new File(WsdlRequestStepTest.class.getResource("/sample-soapui-project.xml").toURI());
        WsdlProject project = new WsdlProject(sampleProjectFile.getAbsolutePath());
        TestSuite testSuite = project.getTestSuiteByName("Test Suite");
        com.eviware.soapui.model.testsuite.TestCase testCase = testSuite.getTestCaseByName("Test Conversions");

        WsdlTestRequestStep testStep = (WsdlTestRequestStep) testCase.getTestStepByName("SEK to USD Test");

        MockTestRunner testRunner = new MockTestRunner(testStep.getTestCase());
        MockTestRunContext testRunContext = new MockTestRunContext(testRunner, testStep);

        TestStepResult result = testStep.run(testRunner, testRunContext);

        WsdlTestRequestStepResult wsdlResult = (WsdlTestRequestStepResult) result;
        assertNotNull(wsdlResult);
    }
}
