

package com.eviware.soapui.model;

import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.support.action.swing.ActionList;
import com.eviware.soapui.support.components.SimpleForm;

/**
 * Behavior for an implementation of the soapui core model
 *
 * @author Ole.Matzura
 */

public interface ModelImplementation {
    public SimpleForm[] getOptions();

    public ActionList getActions();

    public Project buildProject(String path);
}
