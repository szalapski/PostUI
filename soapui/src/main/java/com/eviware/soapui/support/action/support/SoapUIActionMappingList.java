

package com.eviware.soapui.support.action.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.SoapUIActionMapping;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A list of SoapUIActionMappings
 *
 * @author ole.matzura
 */

public class SoapUIActionMappingList<T extends ModelItem> extends ArrayList<SoapUIActionMapping<T>> {
    public SoapUIActionMappingList() {
        super();
    }

    public SoapUIActionMappingList(Collection<? extends SoapUIActionMapping<T>> arg0) {
        super(arg0);
    }

    public int getMappingIndex(String id) {
        for (int c = 0; c < size(); c++) {
            if (get(c).getActionId().equals(id)) {
                return c;
            }
        }

        return -1;
    }

    public SoapUIActionMapping<T> getMapping(String id) {
        for (SoapUIActionMapping<T> mapping : this) {
            if (mapping.getActionId().equals(id)) {
                return mapping;
            }
        }

        return null;
    }
}
