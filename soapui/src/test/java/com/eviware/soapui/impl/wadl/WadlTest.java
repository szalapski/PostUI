

package com.eviware.soapui.impl.wadl;

import net.java.dev.wadl.x2009.x02.ApplicationDocument;
import net.java.dev.wadl.x2009.x02.ApplicationDocument.Application;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WadlTest {

    @Test
    public void testWadl() throws Exception {
        ApplicationDocument applicationDocument = ApplicationDocument.Factory.newInstance();
        Application application = applicationDocument.addNewApplication();
        assertNotNull(application);
    }
}
