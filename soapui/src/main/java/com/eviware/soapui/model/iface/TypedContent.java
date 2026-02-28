

package com.eviware.soapui.model.iface;

/**
 * @author joel.jonsson
 */
public interface TypedContent {
    public String getContentAsString();

    public String getContentType();

    public long getContentLength();
}
