

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.iface.InterfaceListener;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.iface.Request;

/**
 * Adapter for InterfaceListener implementations
 *
 * @author Ole.Matzura
 */

public class InterfaceListenerAdapter implements InterfaceListener {
    public void operationAdded(Operation operation) {
    }

    public void operationRemoved(Operation operation) {
    }

    public void requestAdded(Request request) {
    }

    public void requestRemoved(Request request) {
    }

    public void operationUpdated(Operation operation) {
    }
}
