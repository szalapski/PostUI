

package com.eviware.soapui.support.actions;

import javax.swing.JComponent;

/**
 * Behaviour for any component that supports Find-and-Replace
 *
 * @author ole.matzura
 */

public interface FindAndReplaceable {
    public boolean isEditable();

    public int getCaretPosition();

    public String getText();

    public void select(int start, int end);

    public int getSelectionStart();

    public int getSelectionEnd();

    public void setSelectedText(String txt);

    public String getSelectedText();

    public JComponent getEditComponent();
}
