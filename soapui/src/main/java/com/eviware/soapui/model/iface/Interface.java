

package com.eviware.soapui.model.iface;

import com.eviware.soapui.impl.support.DefinitionContext;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.project.Project;

import java.util.List;

/**
 * An Interface exposing operations
 *
 * @author Ole.Matzura
 */

public interface Interface extends ModelItem {
    public final static String ENDPOINT_PROPERTY = Interface.class.getName() + "@endpoint";

    public final static String DEFINITION_PROPERTY = Interface.class.getName() + "@definition";

    public final static String UPDATING_PROPERTY = Interface.class.getName() + "@updating";

    public String[] getEndpoints();

    public Operation getOperationAt(int index);

    public int getOperationCount();

    public Operation getOperationByName(String name);

    public Project getProject();

    public void addInterfaceListener(InterfaceListener listener);

    public void removeInterfaceListener(InterfaceListener listener);

    public String getTechnicalId();

    public List<Operation> getOperationList();

    public String getInterfaceType();

    public void addEndpoint(String endpoint);

    public void removeEndpoint(String ep);

    public void changeEndpoint(String endpoint, String string);

    public DefinitionContext<?> getDefinitionContext();

    public Operation[] getAllOperations();
}
