

package com.eviware.soapui.support.action;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * A group of actions for a ModelItem
 *
 * @author ole.matzura
 */

public interface SoapUIActionGroup<T extends ModelItem> {
    public String getId();

    public String getName();

    public SoapUIActionMappingList<T> getActionMappings(T modelItem);

    public SoapUIActionMapping<? extends ModelItem> addMapping(String id, SoapUIActionMapping<T> mapping);

    public SoapUIActionMapping<? extends ModelItem> addMapping(String id, int index, SoapUIActionMapping<T> mapping);

    public int getMappingIndex(String positionRef);
}
