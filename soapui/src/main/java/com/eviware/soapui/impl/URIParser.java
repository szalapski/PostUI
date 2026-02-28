

package com.eviware.soapui.impl;


/**
 * URIParser should parse the URI based on ths standard syntax components referred
 * in {@see <a href="http://www.ietf.org/rfc/rfc3986.txt">} as [scheme:][//authority][path][?query][#fragment]
 *
 * @author Shadid Chowdhury
 * @since 4.5.6
 */

public interface URIParser {

    /**
     * This method returns the scheme of the URI if there is one, otherwise empty space.
     *
     * @return scheme of a the URI
     */
    public String getScheme();

    /**
     * This method returns the decoded authority component of the URI.
     * Usually authority is composed of hostname and port.
     *
     * @return decoded authority of the URI or empty space if there is no authority in the URI
     */
    //public String getAuthority();

    /**
     * This method returns the decoded path of the URI.
     *
     * @return decoded path of the URI or empty space if there is no path in the URI
     */
    public String getResourcePath();

    /**
     * This method returns the decoded query of the URI.
     *
     * @return decoded query of the URI or empty space if there is no query in the URI
     */
    public String getQuery();

}
