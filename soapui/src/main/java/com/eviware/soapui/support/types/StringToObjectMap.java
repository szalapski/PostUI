

package com.eviware.soapui.support.types;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap&lt;String,String&gt;
 *
 * @author Ole.Matzura
 */

public class StringToObjectMap extends HashMap<String, Object> {
    public StringToObjectMap() {
        super();
    }

    public StringToObjectMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public StringToObjectMap(int initialCapacity) {
        super(initialCapacity);
    }

    public StringToObjectMap(Map<? extends String, ? extends Object> m) {
        super(m);
    }

}
