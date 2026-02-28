

package com.eviware.soapui.support;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class DefaultHyperlinkListener implements HyperlinkListener {
    private final JEditorPane editorPane;

    public DefaultHyperlinkListener(JEditorPane editorPane) {
        this.editorPane = editorPane;
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            if (e.getURL().getRef() != null) {
                editorPane.scrollToReference(e.getURL().getRef());
            } else {
                Tools.openURL(e.getURL().toString());
            }
        }
    }
}
