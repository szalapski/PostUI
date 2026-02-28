

package com.eviware.soapui.impl.wsdl;

import com.eviware.soapui.config.TestCaseConfig;
import com.eviware.soapui.config.TestStepConfig;
import org.apache.xmlbeans.XmlCursor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MoveXmlTest {

    @Test
    public void movesXmlCorrectly() throws Exception {
        TestCaseConfig testCase = TestCaseConfig.Factory.newInstance();
        TestStepConfig step1 = testCase.addNewTestStep();
        TestStepConfig step2 = testCase.addNewTestStep();
        TestStepConfig step3 = testCase.addNewTestStep();

        List<TestStepConfig> testSteps = testCase.getTestStepList();
        assertEquals(3, testSteps.size());
        assertEquals(testSteps.get(0), step1);
        assertEquals(testSteps.get(1), step2);
        assertEquals(testSteps.get(2), step3);

        XmlCursor cursor1 = step3.newCursor();
        XmlCursor cursor2 = step2.newCursor();

        cursor1.moveXml(cursor2);

        cursor1.dispose();
        cursor2.dispose();

        assertEquals(testSteps.get(0), step1);
        // assertEquals( testSteps.get( 1 ), step3 );
        assertEquals(testSteps.get(2), step2);
    }
}
