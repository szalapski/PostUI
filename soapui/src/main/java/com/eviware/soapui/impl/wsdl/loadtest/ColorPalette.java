

package com.eviware.soapui.impl.wsdl.loadtest;

import com.eviware.soapui.model.ModelItem;

import java.awt.Color;

/**
 * Utility for getting unique colors (for graphs, etc)
 *
 * @author Ole.Matzura
 */

public class ColorPalette {
    public static Color getColor(Object object) {
        if (object instanceof ModelItem) {
            return new Color(((ModelItem) object).getName().hashCode()).brighter();
        } else {
            return new Color(object.hashCode());
        }
    }
}
