

package com.eviware.soapui.model.testsuite;

import javax.xml.namespace.QName;

public interface TestJdbcDriver {
    public String getName();

    public String getDescription();

    public String getConnectionTemplateString();

    public String getDefaultValue();

    public void setConnectionTemplateString(String connectionTemplateString);

    public boolean isReadOnly();

    public QName getType();

    // public enum Type { STRING };

    // /**
    // * Gets the modelItem containing this property
    // *
    // * @return the modelItem containing this property
    // */
    //
    // public ModelItem getModelItem();
}
