

package com.eviware.soapui.model.iface;

import com.eviware.soapui.model.propertyexpansion.PropertyExpansionContext;

/**
 * Context information for a submit
 *
 * @author Ole.Matzura
 */

public interface SubmitContext extends PropertyExpansionContext {
    public static final String HTTP_STATE_PROPERTY = "#HTTP_STATE";
    public static final String PROPERTY_SEPARATOR = "#";
}
