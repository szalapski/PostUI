

package org.apache.http.localserver;

import java.net.InetSocketAddress;

import org.apache.http.HttpHost;
import org.junit.After;

/**
 * Base class for tests using {@link LocalTestServer}. The server will not be
 * started per default.
 */
public abstract class BasicServerTestBase {
    /**
     * The local server for testing.
     */
    protected LocalTestServer localServer;

    @After
    public void tearDown() throws Exception {
        if (localServer != null) {
            localServer.stop();
        }
    }

    /**
     * Obtains the address of the local test server.
     *
     * @return the test server host, with a scheme name of "http"
     */
    protected HttpHost getServerHttp() {
        InetSocketAddress address = localServer.getServiceAddress();
        return new HttpHost(address.getHostName(), address.getPort(), "http");
    }

}
