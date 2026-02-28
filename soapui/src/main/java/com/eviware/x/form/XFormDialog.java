

package com.eviware.x.form;

import com.eviware.soapui.support.action.swing.ActionList;
import com.eviware.soapui.support.types.StringToStringMap;

import javax.swing.Action;

public interface XFormDialog {
    public final static int OK_OPTION = 1;
    public final static int CANCEL_OPTION = 2;

    public void setValues(StringToStringMap values);

    public StringToStringMap getValues();

    public void setVisible(boolean visible);

    public int getReturnValue();

    public void setValue(String field, String value);

    public String getValue(String field);

    public boolean show();

    public StringToStringMap show(StringToStringMap values);

    public boolean validate();

    public void setOptions(String field, Object[] options);

    public XFormField getFormField(String name);

    public void setFormFieldProperty(String name, Object value);

    public int getValueIndex(String name);

    public int getIntValue(String name, int defaultValue);

    public boolean getBooleanValue(String name);

    public void setBooleanValue(String name, boolean b);

    public void setIntValue(String name, int value);

    public void setWidth(int i);

    public void release();

    public void addAction(Action action);

    public XForm[] getForms();

    public void setSize(int i, int j);

    ActionList getActionsList();
}
