

package com.eviware.soapui.support.editor.inspectors.auth;

import com.eviware.soapui.impl.rest.OAuth2Profile;

import javax.annotation.Nonnull;

public interface OAuth2AccessTokenStatusChangeListener {
    /**
     * @param status The new Access Token status
     */
    void onAccessTokenStatusChanged(@Nonnull OAuth2Profile.AccessTokenStatus status);

    /**
     * @return The OAuth 2 profile associated with the listener
     */
    @Nonnull
    OAuth2Profile getProfile();
}
