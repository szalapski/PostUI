

package com.eviware.soapui.model.propertyexpansion.resolvers.providers;

import com.eviware.soapui.impl.wsdl.support.AbstractTestCaseRunner;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by ole on 27/05/14.
 */

public class CurrentRunStepIndexProviderTest
{
    @Test
    public void testProvider()
    {
        CurrentRunStepIndexProvider provider = new CurrentRunStepIndexProvider();

        WsdlTestRunContext context = Mockito.mock(WsdlTestRunContext.class);
        AbstractTestCaseRunner runner = Mockito.mock(AbstractTestCaseRunner.class);
        Mockito.when( runner.getResultCount()).thenReturn( 3 );

        Mockito.when( context.getTestRunner()).thenReturn(runner);

        Assert.assertEquals( "3", provider.getValue( context ));
    }
}
