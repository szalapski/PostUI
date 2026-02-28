

package com.eviware.x.form.support;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XFormRadioGroupTopButtonPosition extends XFormRadioGroup {

    public XFormRadioGroupTopButtonPosition(String[] values) {
        super(values);
    }

    public void addItem(Object value) {
        JRadioButton button = new JRadioButton(String.valueOf(value));
        button.setVerticalTextPosition(SwingConstants.TOP);

        button.setActionCommand(String.valueOf(value));
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fireValueChanged(e.getActionCommand(), null);
            }
        });

        getComponent().add(button);
        buttonGroup.add(button);
        models.put(String.valueOf(value), button.getModel());
        items.add(String.valueOf(value));
    }

}
