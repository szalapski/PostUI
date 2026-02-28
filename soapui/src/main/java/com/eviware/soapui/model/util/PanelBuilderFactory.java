

package com.eviware.soapui.model.util;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.PanelBuilder;

public interface PanelBuilderFactory<T extends ModelItem> {
    public PanelBuilder<T> createPanelBuilder();

    public Class<T> getTargetModelItem();
}
