

package com.eviware.soapui.impl.wsdl.support.wsdl;

import com.eviware.soapui.config.DefinitionCacheConfig;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UrlWsdlLoaderTest {

    @Test
    public void cachesWsdl() throws Exception {
        File file = new File(UrlWsdlLoaderTest.class.getResource("/test6/TestService.wsdl").toURI());
        WsdlLoader loader = new UrlWsdlLoader(file.toURI().toURL().toString());

        DefinitionCacheConfig cachedWsdl = WsdlUtils.cacheWsdl(loader);
        assertThat(cachedWsdl.sizeOfPartArray(), is(4));
    }

    @Test
    public void urlWithoutBasicAuthentication() throws Exception {
        URL url = new URL("http://test/test6/TestService.wsdl");
        WsdlLoader loader = new UrlWsdlLoader(url.toString());

        assertNull(loader.getUsername());
        assertNull(loader.getPassword());
    }
    
    @Test
    public void urlWithBasicAuthentication() throws Exception {
        URL url = new URL("http://username:password@test/test6/TestService.wsdl");
        WsdlLoader loader = new UrlWsdlLoader(url.toString());
        
        assertThat(loader.getUsername(), is("username"));
        assertThat(loader.getPassword(), is("password"));
    }
    
    @Test
    public void urlWithBasicAuthenticationAndAtSymbol() throws Exception {
        URL url = new URL("http://username:passw@rd@test/test6/TestService.wsdl");
        WsdlLoader loader = new UrlWsdlLoader(url.toString());
        
        assertThat(loader.getUsername(), is("username"));
        assertThat(loader.getPassword(), is("passw@rd"));
    }
}
