

package com.eviware.soapui.impl.rest.actions.oauth;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class OAuth2AccessTokenResponseTest {

    public static final String DUMMY_ACCESS_TOKEN = "dummy_access_token";
    public static final String DUMMY_REFRESH_TOKEN = "dummy_refresh_token";
    public static final long EXPIRES_IN = 3600L;
    private OAuth2AccessTokenResponse tokenResponse;

    @Before
    public void setUp() {
        tokenResponse = new OAuth2AccessTokenResponse();
    }

    @Test
    public void readsTokenFromJSONBody() throws OAuthProblemException {
        String jsonBody = "{\n" +
                "  \"access_token\" : \"" + DUMMY_ACCESS_TOKEN + "\",\n" +
                "  \"token_type\" : \"Bearer\",\n" +
                "  \"expires_in\" : " + EXPIRES_IN + ",\n" +
                "  \"refresh_token\" : \"" + DUMMY_REFRESH_TOKEN + "\"\n" +
                "}";

        tokenResponse.setBody(jsonBody);

        assertTokenResponseParameters(tokenResponse);
    }

    @Test
    public void readsTokenFromFormURLEncodedBody() throws OAuthProblemException {
        tokenResponse.setBody(getFormUrlEncodedresponseBody());

        assertTokenResponseParameters(tokenResponse);
    }

    @Test
    public void readsTokenFromFormURLEncodedBodyWithHash() throws OAuthProblemException {
        tokenResponse.setBody("#" + getFormUrlEncodedresponseBody());

        assertTokenResponseParameters(tokenResponse);
    }

    private void assertTokenResponseParameters(OAuth2AccessTokenResponse tokenResponse) {
        assertThat(tokenResponse.getAccessToken(), is(DUMMY_ACCESS_TOKEN));
        assertThat(tokenResponse.getExpiresIn(), is(EXPIRES_IN));
        assertThat(tokenResponse.getRefreshToken(), is(DUMMY_REFRESH_TOKEN));
    }

    private String getFormUrlEncodedresponseBody() {
        return "access_token=" + DUMMY_ACCESS_TOKEN + "&expires_in=" + EXPIRES_IN + "&refresh_token=" +
                DUMMY_REFRESH_TOKEN + "&token_type=Bearer";
    }

}
