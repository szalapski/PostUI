

package com.eviware.soapui.support.action;

import com.eviware.soapui.model.ModelItem;

/**
 * Extend SoapUIAction for multi-target actions
 *
 * @param <T>
 * @author ole
 */

public interface SoapUIMultiAction extends SoapUIAction<ModelItem> {
    public void perform(ModelItem[] targets, Object param);
}
