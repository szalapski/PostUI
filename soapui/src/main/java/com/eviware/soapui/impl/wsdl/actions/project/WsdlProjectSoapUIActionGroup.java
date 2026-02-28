

package com.eviware.soapui.impl.wsdl.actions.project;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.submit.transports.jms.util.HermesUtils;
import com.eviware.soapui.support.action.SoapUIActionGroup;
import com.eviware.soapui.support.action.support.AbstractSoapUIActionGroup;
import com.eviware.soapui.support.action.support.SoapUIActionMappingList;

/**
 * SoapUIActionGroup for WsdlProjects, returns different actions depending on if
 * the project is disabled or not.
 *
 * @author ole.matzura
 */

public class WsdlProjectSoapUIActionGroup extends AbstractSoapUIActionGroup<WsdlProject> {
    public WsdlProjectSoapUIActionGroup(String id, String name) {
        super(id, name);
    }

    public SoapUIActionMappingList<WsdlProject> getActionMappings(WsdlProject project) {
        if (project.isDisabled()) {
            SoapUIActionGroup<WsdlProject> actionGroup = SoapUI.getActionRegistry().getActionGroup(
                    "DisabledWsdlProjectActions");
            return actionGroup.getActionMappings(project);
        } else if (!project.isOpen()) {
            if (project.getEncryptionStatus() != WsdlProject.ProjectEncryptionStatus.NOT_ENCRYPTED) {
                SoapUIActionGroup<WsdlProject> actionGroup = SoapUI.getActionRegistry().getActionGroup(
                        "EncryptedWsdlProjectActions");
                return actionGroup.getActionMappings(project);
            } else {
                SoapUIActionGroup<WsdlProject> actionGroup = SoapUI.getActionRegistry().getActionGroup(
                        "ClosedWsdlProjectActions");
                return actionGroup.getActionMappings(project);
            }
        } else {
            SoapUIActionGroup<WsdlProject> actionGroup = SoapUI.getActionRegistry().getActionGroup(
                    "EnabledWsdlProjectActions");
            SoapUIActionMappingList<WsdlProject> mappings = actionGroup.getActionMappings(project);

            mappings.getMapping(SaveProjectAction.SOAPUI_ACTION_ID).setEnabled(
                    !project.isRemote());
            //mappings.getMapping(StartHermesJMS.SOAPUI_ACTION_ID).setEnabled(HermesUtils.isHermesJMSSupported());

            return mappings;
        }
    }
}
