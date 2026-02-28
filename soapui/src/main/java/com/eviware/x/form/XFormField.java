

package com.eviware.x.form;

public interface XFormField {
    public final static String CURRENT_DIRECTORY = XFormField.class.getName() + "@currentDirectory";

    public void setValue(String value);

    public String getValue();

    public void setEnabled(boolean enabled);

    public boolean isEnabled();

    public void setRequired(boolean required, String message);

    public boolean isRequired();

    public void setToolTip(String tooltip);

    public void addFormFieldListener(XFormFieldListener listener);

    public void removeFieldListener(XFormFieldListener listener);

    public void addFormFieldValidator(XFormFieldValidator validator);

    public void removeFormFieldValidator(XFormFieldValidator validator);

    public void addComponentEnabler(XFormField tf, String value);

    public void setProperty(String name, Object value);

    public Object getProperty(String name);

    public ValidationMessage[] validate();

    boolean isVisible();
}
