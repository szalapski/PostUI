

package com.eviware.soapui.impl.rest.actions.oauth;

import com.eviware.soapui.support.StringUtils;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.codehaus.jettison.json.JSONException;

/**
 *
 */
public class OAuth2AccessTokenResponse extends OAuthAccessTokenResponse {

    private static final String EXPIRES = "expires";

    @Override
    public String getAccessToken() {
        return getParam(OAuth.OAUTH_ACCESS_TOKEN);
    }

    @Override
    public Long getExpiresIn() {
        String value = getParam(OAuth.OAUTH_EXPIRES_IN) == null ? getParam(EXPIRES) : getParam(OAuth.OAUTH_EXPIRES_IN);
        return value == null ? null : Long.valueOf(value);
    }

    public String getScope() {
        return getParam(OAuth.OAUTH_SCOPE);
    }

    public OAuthToken getOAuthToken() {
        return new BasicOAuthToken(getAccessToken(), getExpiresIn(), getRefreshToken(), getScope());
    }

    public String getRefreshToken() {
        return getParam(OAuth.OAUTH_REFRESH_TOKEN);
    }

    protected void setBody(String body) throws OAuthProblemException {

        try {
            this.body = body;
            parameters = JSONUtils.parseJSON(body);
        } catch (JSONException e) {
            if (body.startsWith("#")) {
                body = body.substring(1);
            }
            parameters = OAuthUtils.decodeForm(body);
            if (StringUtils.isNullOrEmpty(getAccessToken())) {
                throw OAuthProblemException.error(OAuthError.CodeResponse.UNSUPPORTED_RESPONSE_TYPE,
                        "Invalid response! Response body is not " + OAuth.ContentType.JSON + " encoded or form-url-encoded");
            }
        }
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }


    protected void setResponseCode(int code) {
        this.responseCode = code;
    }

}
