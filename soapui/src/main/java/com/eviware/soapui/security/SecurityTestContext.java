

package com.eviware.soapui.security;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.DefaultPropertyExpansionContext;

/**
 * SecurityTestContext implementation for SecurityTests not active - just left
 * in case needed later
 *
 * @author SoapUI team
 */

public class SecurityTestContext extends DefaultPropertyExpansionContext
// implements SecurityTestRunContext
{

    public SecurityTestContext(ModelItem modelItem) {
        super(modelItem);
        // TODO Auto-generated constructor stub
    }
    // private final SecurityTestRunner runner;
    //
    // public SecurityTestContext( SecurityTestRunner runner )
    // {
    // super( runner.getSecurityTest().getTestCase() );
    // this.runner = runner;
    // }
    //
    // public SecurityTestRunner getSecurityTestRunner()
    // {
    // return runner;
    // }
    //
    // @Override
    // public Object get( Object key )
    // {
    // if( "securityTestRunner".equals( key ) )
    // return runner;
    //
    // return super.get( key );
    // }
    //
    // public Object getProperty( String testStep, String propertyName )
    // {
    // return null;
    // }
    //
    // public TestCaseRunner getTestRunner()
    // {
    // return null;
    // }
}
