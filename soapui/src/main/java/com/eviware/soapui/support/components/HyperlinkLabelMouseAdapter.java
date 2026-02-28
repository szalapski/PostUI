

package com.eviware.soapui.support.components;

import com.eviware.soapui.support.Tools;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class HyperlinkLabelMouseAdapter extends MouseAdapter {
    private final JComponent label;

    public HyperlinkLabelMouseAdapter(JTextComponent label) {
        this.label = label;
    }

    public HyperlinkLabelMouseAdapter(JLabel label) {
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String text = label instanceof JLabel ? ((JLabel) label).getText() : ((JTextComponent) label).getText();
        Tools.openURL(text);
    }
}
