

package com.eviware.soapui.support.components;

import com.eviware.soapui.support.Tools;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JHyperlinkLabel extends JLabel {
    private Color underlineColor = null;

    public JHyperlinkLabel(String label) {
        super(label);

        setForeground(Color.BLUE.darker());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new HyperlinkLabelMouseAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(underlineColor == null ? getForeground() : underlineColor);

        Insets insets = getInsets();

        int left = insets.left;
        if (getIcon() != null) {
            left += getIcon().getIconWidth() + getIconTextGap();
        }

        g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getPreferredSize().getWidth() - insets.right,
                getHeight() - 1 - insets.bottom);
    }

    public class HyperlinkLabelMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Tools.openURL(getText());
        }
    }

    public Color getUnderlineColor() {
        return underlineColor;
    }

    public void setUnderlineColor(Color underlineColor) {
        this.underlineColor = underlineColor;
    }
}
