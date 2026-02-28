

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.TestModelItem;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.support.types.StringToObjectMap;

import java.util.List;
import java.util.UUID;

/**
 * A TestSuite holding a number of TestCases
 *
 * @author Ole.Matzura
 */

public interface TestSuite extends TestModelItem, ResultContainer, TestRunnable {
    public final static String RUNTYPE_PROPERTY = ModelItem.class.getName() + "@runtype";
    public final static String DISABLED_PROPERTY = TestSuite.class.getName() + "@disabled";

    public Project getProject();

    public int getTestCaseCount();

    public TestCase getTestCaseAt(int index);

    public TestCase getTestCaseByName(String testCaseName);

    public TestCase getTestCaseById(UUID id);

    public List<TestCase> getTestCaseList();

    public void addTestSuiteListener(TestSuiteListener listener);

    public void removeTestSuiteListener(TestSuiteListener listener);

    public enum TestSuiteRunType {
        PARALLEL, SEQUENTIAL
    }

    ;

    public TestSuiteRunType getRunType();

    public int getIndexOfTestCase(TestCase testCase);

    public boolean isDisabled();

    public String getLabel();

    public TestSuiteRunner run(StringToObjectMap context, boolean async);

    public void addTestSuiteRunListener(TestSuiteRunListener listener);

    public void removeTestSuiteRunListener(TestSuiteRunListener listener);
}
