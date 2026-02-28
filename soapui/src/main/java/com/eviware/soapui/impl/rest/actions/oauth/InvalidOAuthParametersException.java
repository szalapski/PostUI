

package com.eviware.soapui.impl.rest.actions.oauth;

/**
 * Thrown when an OAuth2Profile instance holds invalid values.
 */
public class InvalidOAuthParametersException extends IllegalArgumentException {

    public InvalidOAuthParametersException(String s) {
        super(s);
    }
}
