

package com.eviware.soapui.impl.wsdl.actions.iface;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.submit.transports.jms.util.HermesUtils;
import com.eviware.soapui.support.action.support.DefaultSoapUIActionGroup;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * ActionGroup handler for WsdlInterface
 *
 * @author ole.matzura
 */

public class WsdlInterfaceSoapUIActionGroup extends DefaultSoapUIActionGroup<WsdlInterface> {
    public WsdlInterfaceSoapUIActionGroup(String id, String name) {
        super(id, name);
    }

    @Override
    public SoapUIActionMappingList<WsdlInterface> getActionMappings(WsdlInterface modelItem) {
        SoapUIActionMappingList<WsdlInterface> actionMappings = super.getActionMappings(modelItem);

        actionMappings.getMapping(AddJMSEndpointAction.SOAPUI_ACTION_ID)
                .setEnabled(HermesUtils.isHermesJMSSupported());
        // SoapUIActionMapping<WsdlInterface> mapping = actionMappings.getMapping(
        // WSToolsRegenerateJava2WsdlAction.SOAPUI_ACTION_ID );
        // WSToolsRegenerateJava2WsdlAction action = (
        // WSToolsRegenerateJava2WsdlAction ) mapping.getAction();
        // mapping.setEnabled( modelItem.getSettings().isSet(
        // action.getValuesSettingID() ) );

        return actionMappings;
    }
}
