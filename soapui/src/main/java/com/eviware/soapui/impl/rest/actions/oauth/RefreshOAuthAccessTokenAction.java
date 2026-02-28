

package com.eviware.soapui.impl.rest.actions.oauth;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.rest.OAuth2Profile;
import com.eviware.soapui.support.MessageSupport;
import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

/**
 * Action for retrieving an OAuth2 access token using the values in the OAuth2Profile object.
 */
public class RefreshOAuthAccessTokenAction extends AbstractAction {
    private static final MessageSupport messages = MessageSupport.getMessages(RefreshOAuthAccessTokenAction.class);
    private OAuth2Profile profile;

    public RefreshOAuthAccessTokenAction(OAuth2Profile profile) {
        super(messages.get("RefreshOAuthAccessTokenAction.Action.Name"));
        this.profile = profile;
        putValue(Action.SHORT_DESCRIPTION, messages.get("RefreshOAuthAccessTokenAction.Action.Description"));
    }

    public void actionPerformed(ActionEvent event) {
        try {
            getOAuthClientFacade().refreshAccessToken(profile);
        } catch (InvalidOAuthParametersException e) {
            UISupport.showErrorMessage(messages.get("RefreshOAuthAccessTokenAction.Error.InvalidParameters", e.getMessage()));
        } catch (Exception e) {
            SoapUI.logError(e, messages.get("RefreshOAuthAccessTokenAction.Error.RefreshingFailLog"));
            UISupport.showErrorMessage(messages.get("RefreshOAuthAccessTokenAction.Error.RefreshingFailMessage"));
        }
    }

    protected OAuth2ClientFacade getOAuthClientFacade() {
        return new OltuOAuth2ClientFacade();
    }
}
