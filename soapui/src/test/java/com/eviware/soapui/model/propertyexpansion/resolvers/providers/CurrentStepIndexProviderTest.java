

package com.eviware.soapui.model.propertyexpansion.resolvers.providers;

import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by ole on 27/05/14.
 */

public class CurrentStepIndexProviderTest
{
    @Test
    public void testProvider()
    {
        CurrentStepIndexProvider provider = new CurrentStepIndexProvider();

        TestCaseRunContext context = Mockito.mock(TestCaseRunContext.class);
        Mockito.when( context.getCurrentStepIndex()).thenReturn( 3 );

        Assert.assertEquals( "3", provider.getValue( context ));
    }
}
