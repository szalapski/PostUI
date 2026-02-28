

package com.eviware.soapui.model.support;

import com.eviware.soapui.support.types.StringToObjectMap;

import java.util.Map;

/**
 * Specialization of HashMap&lt;String,Object&gt;
 *
 * @author Ole.Matzura
 */

public class PropertiesMap extends StringToObjectMap {
    public PropertiesMap() {
        super();
    }

    public PropertiesMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public PropertiesMap(int initialCapacity) {
        super(initialCapacity);
    }

    public PropertiesMap(Map<? extends String, ? extends Object> m) {
        super(m);
    }
}
