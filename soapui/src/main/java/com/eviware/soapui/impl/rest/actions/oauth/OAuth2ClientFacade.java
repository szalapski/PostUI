

package com.eviware.soapui.impl.rest.actions.oauth;

import com.eviware.soapui.impl.rest.OAuth2Profile;
import org.apache.http.client.methods.HttpRequestBase;

public interface OAuth2ClientFacade {
    void requestAccessToken(OAuth2Profile profile) throws OAuth2Exception;

    void applyAccessToken(OAuth2Profile profile, HttpRequestBase request, String requestContent);

    void refreshAccessToken(OAuth2Profile profile) throws Exception;
}
