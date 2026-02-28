

package com.eviware.soapui.impl.wadl.inference.support;

import com.eviware.soapui.impl.wadl.inference.ConflictHandler;

import javax.xml.namespace.QName;

/**
 * A ConflictHandler that denies any attempt to change the inferred schema.
 *
 * @author Dain Nilsson
 */
public class DenyAll implements ConflictHandler {
    /**
     * Constructs a new DenyAll instance.
     */
    public DenyAll() {

    }

    public boolean callback(Event event, Type type, QName name, String path, String message) {
        return false;
    }

}
