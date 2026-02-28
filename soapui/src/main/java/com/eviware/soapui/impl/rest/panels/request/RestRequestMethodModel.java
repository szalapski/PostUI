

package com.eviware.soapui.impl.rest.panels.request;

import com.eviware.soapui.impl.rest.RestRequestInterface;

import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class RestRequestMethodModel extends DefaultComboBoxModel implements PropertyChangeListener {
    private RestRequestInterface request;

    public RestRequestMethodModel(RestRequestInterface request) {
        super(RestRequestInterface.HttpMethod.values());
        this.request = request;
        request.addPropertyChangeListener(this);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        super.setSelectedItem(anItem);
        request.setMethod((RestRequestInterface.HttpMethod) anItem);
    }

    @Override
    public Object getSelectedItem() {
        return request.getMethod();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fireContentsChanged(this, -1, -1);
    }
}
