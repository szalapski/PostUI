

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.support.action.SoapUIActionMapping;
import com.eviware.soapui.support.action.support.DefaultSoapUIActionGroup;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * SoapUIActionGroup for WsdlTestSteps
 *
 * @author ole.matzura
 */

public class WsdlTestCaseSoapUIActionGroup extends DefaultSoapUIActionGroup<WsdlTestCase> {
    public WsdlTestCaseSoapUIActionGroup(String id, String name) {
        super(id, name);
    }

    public SoapUIActionMappingList<WsdlTestCase> getActionMappings(WsdlTestCase modelItem) {
        SoapUIActionMappingList<WsdlTestCase> actions = super.getActionMappings(modelItem);
        SoapUIActionMapping<WsdlTestCase> toggleDisabledActionMapping = null;

        for (int c = 0; c < actions.size(); c++) {
            if (actions.get(c).getActionId().equals(ToggleDisableTestCaseAction.SOAPUI_ACTION_ID)) {
                toggleDisabledActionMapping = actions.get(c);
                break;
            }
        }

        if (toggleDisabledActionMapping != null && modelItem != null) {
            if (modelItem.isDisabled()) {
                toggleDisabledActionMapping.setName("Enable TestCase");
                toggleDisabledActionMapping.setDescription("Enable this TestCase");
            } else {
                toggleDisabledActionMapping.setName("Disable TestCase");
                toggleDisabledActionMapping.setDescription("Disables this TestCase");
            }
        }

        return actions;
    }
}
