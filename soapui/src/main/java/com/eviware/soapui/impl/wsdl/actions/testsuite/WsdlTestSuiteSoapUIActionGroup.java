

package com.eviware.soapui.impl.wsdl.actions.testsuite;

import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.support.action.SoapUIActionMapping;
import com.eviware.soapui.support.action.support.DefaultSoapUIActionGroup;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * SoapUIActionGroup for WsdlTestSteps
 *
 * @author ole.matzura
 */

public class WsdlTestSuiteSoapUIActionGroup extends DefaultSoapUIActionGroup<WsdlTestSuite> {
    public WsdlTestSuiteSoapUIActionGroup(String id, String name) {
        super(id, name);
    }

    public SoapUIActionMappingList<WsdlTestSuite> getActionMappings(WsdlTestSuite modelItem) {
        SoapUIActionMappingList<WsdlTestSuite> actions = super.getActionMappings(modelItem);
        SoapUIActionMapping<WsdlTestSuite> toggleDisabledActionMapping = null;

        for (int c = 0; c < actions.size(); c++) {
            if (actions.get(c).getActionId().equals(ToggleDisableTestSuiteAction.SOAPUI_ACTION_ID)) {
                toggleDisabledActionMapping = actions.get(c);
                break;
            }
        }

        if (toggleDisabledActionMapping != null && modelItem != null) {
            if (modelItem.isDisabled()) {
                toggleDisabledActionMapping.setName("Enable TestSuite");
                toggleDisabledActionMapping.setDescription("Enable this TestSuite");
            } else {
                toggleDisabledActionMapping.setName("Disable TestSuite");
                toggleDisabledActionMapping.setDescription("Disables this TestSuite");
            }
        }

        return actions;
    }
}
