

package com.eviware.x.form;

/**
 * @author Lars H
 */

public interface XFormOptionsField extends XFormField {
    public void addItem(Object value);

    public void setOptions(Object[] values);

    public Object[] getOptions();

    public Object[] getSelectedOptions();

    public void setSelectedOptions(Object[] options);

    public int[] getSelectedIndexes();
}
