

package com.eviware.soapui.impl.wsdl.actions.testcase;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestStepFactory;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestStepRegistry;
import com.eviware.soapui.support.action.support.DefaultActionMapping;
import com.eviware.soapui.support.action.support.DefaultSoapUIActionGroup;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * SoapUIActionGroup for WsdlTestCases, dynamically creates "Append Step"
 * submenu contents from the WsdlTestStepRegistry
 *
 * @author ole.matzura
 */

public class WsdlTestCaseAddStepSoapUIActionGroup extends DefaultSoapUIActionGroup<WsdlTestCase> {
    public WsdlTestCaseAddStepSoapUIActionGroup(String id, String name) {
        super(id, name);
    }

    public SoapUIActionMappingList<WsdlTestCase> getActionMappings(WsdlTestCase modelItem) {
        SoapUIActionMappingList<WsdlTestCase> actions = new SoapUIActionMappingList<>();

        WsdlTestStepRegistry registry = WsdlTestStepRegistry.getInstance();
        WsdlTestStepFactory[] factories = (WsdlTestStepFactory[]) registry.getFactories();

        for (int c = 0; c < factories.length; c++) {
            WsdlTestStepFactory factory = factories[c];
            if (factory.canCreate()) {
                DefaultActionMapping<WsdlTestCase> actionMapping = new DefaultActionMapping<>(
                        AddWsdlTestStepAction.SOAPUI_ACTION_ID, null, factory.getTestStepIconPath(), false, factory);

                actionMapping.setName(factory.getTestStepName());
                actionMapping.setDescription(factory.getTestStepDescription());

                actions.add(actionMapping);
            }
        }

        return actions;
    }
}
