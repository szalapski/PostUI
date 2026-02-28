/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//httpclient/src/java/org/apache/commons/httpclient/HttpClientError.java,v 1.4 2004/05/13 04:03:25 mbecke Exp $
 * $Revision: 480424 $
 * $Date: 2006-11-29 06:56:49 +0100 (Wed, 29 Nov 2006) $

 */

package org.apache.commons.httpclient;

/**
 * Signals that an error has occurred.
 *
 * @author Ortwin Gl?ck
 * @version $Revision: 480424 $ $Date: 2006-11-29 06:56:49 +0100 (Wed, 29 Nov 2006) $
 * @since 3.0
 */
public class HttpClientError extends Error {

    /**
     * Creates a new HttpClientError with a <tt>null</tt> detail message.
     */
    public HttpClientError() {
        super();
    }

    /**
     * Creates a new HttpClientError with the specified detail message.
     *
     * @param message The error message
     */
    public HttpClientError(String message) {
        super(message);
    }

}
