

package com.eviware.soapui.model.iface;

/**
 * Listener for Submit-related events
 *
 * @author Ole.Matzura
 */

public interface SubmitListener extends SoapUIListener {
    /**
     * Called before submittal of a request
     *
     * @param submit the submit being submitted
     * @return boolean telling if the submit should proceed.
     */

    public boolean beforeSubmit(Submit submit, SubmitContext context);

    /**
     * Called after submittal of a request
     *
     * @param submit the submit.
     */

    public void afterSubmit(Submit submit, SubmitContext context);
}
