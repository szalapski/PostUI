

package com.eviware.soapui.impl.rest;

import com.eviware.soapui.impl.rest.actions.oauth.OAuth2TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for the OAuth2Profile class.
 */
public class OAuth2ProfileTest {

    private OAuth2Profile profile;

    @Before
    public void setUp() throws Exception {
        profile = OAuth2TestUtils.getOAuthProfileWithDefaultValues();

    }

    @Test
    public void trimsAccessTokenWhenSettingIt() throws Exception {
        String accessTokenWithoutWhitespace = "wuryew2347234987";
        profile.setAccessToken("\t" + accessTokenWithoutWhitespace + " \n");

        assertThat(profile.getAccessToken(), is(accessTokenWithoutWhitespace));
    }

    @Test
    public void trimsAccessTokenUriWhenSettingIt() throws Exception {
        String accessTokenUriWithoutWhitespace = "wuryew2347234987";
        profile.setAccessTokenURI("\t" + accessTokenUriWithoutWhitespace + " \n");

        assertThat(profile.getAccessTokenURI(), is(accessTokenUriWithoutWhitespace));
    }

    @Test
    public void trimsAuthorizationUriWhenSettingIt() throws Exception {
        String authorizationUriWithoutWhitespace = "wuryew2347234987";
        profile.setAuthorizationURI("\t" + authorizationUriWithoutWhitespace + " \n");

        assertThat(profile.getAuthorizationURI(), is(authorizationUriWithoutWhitespace));
    }

    @Test
    public void waitsForAccessTokenStatusChange() throws Exception {
        final String accessToken = "mock token";
        profile.setAccessTokenStatus(OAuth2Profile.AccessTokenStatus.WAITING_FOR_AUTHORIZATION);

        Runnable simulatedAccessTokenRetrieval = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignore) {

                }
                profile.applyRetrievedAccessToken(accessToken);
            }
        };
        new Thread(simulatedAccessTokenRetrieval).start();
        profile.waitForAccessTokenStatus(OAuth2Profile.AccessTokenStatus.RETRIEVED_FROM_SERVER, 1000);

        assertThat(profile.getAccessToken(), is(accessToken));
    }

    @Test
    public void ignoresIntermediateAccessTokenStatusChanges() throws Exception {
        final String accessToken = "mock token";
        profile.setAccessTokenStatus(OAuth2Profile.AccessTokenStatus.WAITING_FOR_AUTHORIZATION);

        Runnable simulatedAccessTokenRetrieval = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                    profile.setAccessTokenStatus(OAuth2Profile.AccessTokenStatus.WAITING_FOR_AUTHORIZATION);
                    Thread.sleep(10);
                } catch (InterruptedException ignore) {

                }
                profile.applyRetrievedAccessToken(accessToken);
            }
        };
        new Thread(simulatedAccessTokenRetrieval).start();
        profile.waitForAccessTokenStatus(OAuth2Profile.AccessTokenStatus.RETRIEVED_FROM_SERVER, 1000);

        assertThat(profile.getAccessToken(), is(accessToken));
    }

    @Test
    public void appliesTimeOutCorrectlyEvenOnMultipleStatusChanges() throws Exception {
        final String accessToken = "mock token";
        profile.setAccessTokenStatus(OAuth2Profile.AccessTokenStatus.WAITING_FOR_AUTHORIZATION);

        Runnable simulatedAccessTokenRetrieval = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(100);
                    profile.setAccessTokenStatus(OAuth2Profile.AccessTokenStatus.WAITING_FOR_AUTHORIZATION);
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {

                }
                profile.applyRetrievedAccessToken(accessToken);
            }
        };
        new Thread(simulatedAccessTokenRetrieval).start();
        profile.waitForAccessTokenStatus(OAuth2Profile.AccessTokenStatus.RETRIEVED_FROM_SERVER, 150);

        assertThat(profile.getAccessToken(), is(not((accessToken))));
    }
}
