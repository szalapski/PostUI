

package com.eviware.soapui.model.iface;

/**
 * Listener for Interface-events
 *
 * @author Ole.Matzura
 */

public interface InterfaceListener extends SoapUIListener {
    void operationAdded(Operation operation);

    void operationRemoved(Operation operation);

    void operationUpdated(Operation operation);

    void requestAdded(Request request);

    void requestRemoved(Request request);
}
