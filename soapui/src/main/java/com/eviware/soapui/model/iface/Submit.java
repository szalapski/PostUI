

package com.eviware.soapui.model.iface;

/**
 * Behaviour for a submitted request
 *
 * @author Ole.Matzura
 */

public interface Submit {
    public Request getRequest();

    public Response getResponse();

    public Status waitUntilFinished();

    public void cancel();

    public Status getStatus();

    public Exception getError();

    public enum Status {
        INITIALIZED, RUNNING, CANCELED, FINISHED, ERROR
    }

    ;
}
