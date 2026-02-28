

package com.eviware.soapui.model.iface;

import com.eviware.soapui.model.ModelItem;

import java.util.List;

/**
 * Operation interface
 *
 * @author Ole.Matzura
 */

public interface Operation extends ModelItem {
    public final static String ACTION_PROPERTY = Operation.class.getName() + "@action";

    public boolean isUnidirectional();

    public boolean isBidirectional();

    public Request getRequestAt(int index);

    public Request getRequestByName(String requestName);

    public List<Request> getRequestList();

    public int getRequestCount();

    public Interface getInterface();

    public MessagePart[] getDefaultRequestParts();

    public MessagePart[] getDefaultResponseParts();

    public String createRequest(boolean b);

    public String createResponse(boolean b);
}
