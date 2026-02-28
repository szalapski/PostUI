

package com.eviware.soapui.impl.wsdl.actions.iface.tools.support;

import com.eviware.soapui.analytics.Analytics;
import com.eviware.soapui.analytics.SoapUIActions;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.UISupport;

/**
 * Swing-based ToolHost
 *
 * @author ole.matzura
 */

public class SwingToolHost implements ToolHost {
    public void run(ToolRunner runner) throws Exception {
        ProcessDialog processDialog = null;

        try {
            processDialog = new ProcessDialog(runner.getName(), runner.getDescription(), runner.showLog(),
                    runner.canCancel());
            ModelItem modelItem = runner.getModelItem();
            if (modelItem == null) {
                processDialog.log("Running " + runner.getName() + "\r\n");
            } else {
                processDialog.log("Running " + runner.getName() + " for [" + modelItem.getName() + "]\r\n");
            }
            processDialog.run(runner);
        } catch (Exception ex) {
            UISupport.showErrorMessage(ex);
            throw ex;
        } finally {
            if (processDialog != null) {
                processDialog.setVisible(false);
            }
        }
    }
}
