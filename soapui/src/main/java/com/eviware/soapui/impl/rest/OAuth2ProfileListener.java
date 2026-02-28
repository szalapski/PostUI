

package com.eviware.soapui.impl.rest;

/**
 * @author joel.jonsson
 */
public interface OAuth2ProfileListener {
    void profileAdded(OAuth2Profile profile);

    void profileRemoved(String profileName);

    void profileRenamed(String profileOldName, String newName);
}
