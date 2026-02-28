

package com.eviware.soapui.model.iface;

import com.eviware.soapui.model.ModelItem;

/**
 * Request interface
 *
 * @author Ole.Matzura
 */

public interface Request extends ModelItem {
    public final String REQUEST_PROPERTY = "request";
    public final String ENDPOINT_PROPERTY = "endpoint";
    public final String ENCODING_PROPERTY = "encoding";
    public final String MEDIA_TYPE = "mediaType";

    public String getRequestContent();

    public void setEndpoint(String string);

    public String getEndpoint();

    public String getEncoding();

    public String getTimeout();

    public void setEncoding(String string);

    public Operation getOperation();

    public void addSubmitListener(SubmitListener listener);

    public void removeSubmitListener(SubmitListener listener);

    public Submit submit(SubmitContext submitContext, boolean async) throws SubmitException;

    public Attachment[] getAttachments();

    public MessagePart[] getRequestParts();

    public MessagePart[] getResponseParts();

    public String getUsername();

    public String getPassword();

    public String getAuthType();

    public boolean dependsOn(ModelItem modelItem);

    @SuppressWarnings("serial")
    public static class SubmitException extends Exception {
        public SubmitException(String msg) {
            super(msg);
        }

        public SubmitException(String message, Throwable cause) {
            super(message, cause);
        }

        public SubmitException(Throwable cause) {
            super(cause);
        }
    }
}
