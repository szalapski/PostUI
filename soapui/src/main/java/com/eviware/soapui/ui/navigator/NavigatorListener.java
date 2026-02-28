

package com.eviware.soapui.ui.navigator;

import com.eviware.soapui.model.tree.SoapUITreeNode;

/**
 * Handler for Navigator-events
 *
 * @author Ole.Matzura
 */

public interface NavigatorListener {
    public void nodeSelected(SoapUITreeNode treeNode);
}
