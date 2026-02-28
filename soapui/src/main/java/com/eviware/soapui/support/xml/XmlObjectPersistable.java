

package com.eviware.soapui.support.xml;

import org.apache.xmlbeans.XmlObject;

/**
 * Marker interface for objects that can be saved/restored to/from an XmlObject
 *
 * @author Ole.Matzura
 */

public interface XmlObjectPersistable {
    /**
     * Persisits this object to an XmlObject
     *
     * @return the persisted XmlObject
     */

    public XmlObject save();

    /**
     * Restores this object from the specified XmlObject
     *
     * @param xmlObject the xmlObject to restore from
     */

    public void restore(XmlObject xmlObject);
}
