

package com.eviware.soapui.support.actions;

import com.eviware.soapui.support.UISupport;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JSplitPane;
import java.awt.event.ActionEvent;

/**
 * Changes the orientation of a JSplitPane
 *
 * @author Ole.Matzura
 */

public class ChangeSplitPaneOrientationAction extends AbstractAction {
    private final JSplitPane splitPane;

    public ChangeSplitPaneOrientationAction(JSplitPane splitPane) {
        super();
        this.splitPane = splitPane;

        putValue(Action.SMALL_ICON, UISupport.createImageIcon("/split_request_pane.gif"));
        putValue(Action.SHORT_DESCRIPTION, "Changes the orientation of the request pane split");
        putValue(Action.ACCELERATOR_KEY, UISupport.getKeyStroke("alt O"));
    }

    public void actionPerformed(ActionEvent e) {
        int orientation = splitPane.getOrientation();
        splitPane.setOrientation(orientation == JSplitPane.HORIZONTAL_SPLIT ? JSplitPane.VERTICAL_SPLIT
                : JSplitPane.HORIZONTAL_SPLIT);
        splitPane.resetToPreferredSizes();
    }
}
