

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.ModelItem;
import org.apache.xmlbeans.SchemaType;

import javax.xml.namespace.QName;

public interface TestProperty {
    public String getName();

    public String getDescription();

    public String getValue();

    public String getDefaultValue();

    public void setValue(String value);

    public boolean isReadOnly();

    public QName getType();

    /**
     * Gets the modelItem containing this property
     *
     * @return the modelItem containing this property
     */

    public ModelItem getModelItem();

    /**
     * defines if specific property belongs to request part
     */
    public boolean isRequestPart();

    public SchemaType getSchemaType();
}
