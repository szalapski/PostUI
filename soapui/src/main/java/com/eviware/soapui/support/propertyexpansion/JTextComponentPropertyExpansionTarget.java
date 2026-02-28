

package com.eviware.soapui.support.propertyexpansion;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.propertyexpansion.PropertyExpansion;

import javax.swing.text.JTextComponent;
import java.awt.Point;

public class JTextComponentPropertyExpansionTarget extends AbstractPropertyExpansionTarget {
    private final JTextComponent textField;

    public JTextComponentPropertyExpansionTarget(JTextComponent textField, ModelItem modelItem) {
        super(modelItem);
        this.textField = textField;
    }

    public void insertPropertyExpansion(PropertyExpansion expansion, Point pt) {
        int pos = pt == null ? -1 : textField.viewToModel(pt);
        if (pos == -1) {
            pos = textField.getCaretPosition();
        }

        if (pos == -1 || textField.getSelectionStart() == textField.getSelectionEnd()) {
            textField.setText(expansion.toString());
            textField.requestFocusInWindow();
        } else {
            String text = textField.getText();
            if (textField.getSelectionStart() < textField.getSelectionEnd()) {
                textField.setText(text.substring(0, textField.getSelectionStart()) + expansion
                        + text.substring(textField.getSelectionEnd()));
                textField.setCaretPosition(textField.getSelectionStart());
            } else {
                textField.setText(text.substring(0, pos) + expansion + text.substring(pos));
                textField.setCaretPosition(pos);
            }

            textField.requestFocusInWindow();
        }
    }

    public String getValueForCreation() {
        return textField.getSelectedText() == null ? textField.getText() : textField.getSelectedText();
    }

    public String getNameForCreation() {
        return textField.getName();
    }
}
