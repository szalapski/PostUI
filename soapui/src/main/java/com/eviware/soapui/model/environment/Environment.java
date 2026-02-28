

package com.eviware.soapui.model.environment;

import com.eviware.soapui.config.ServiceConfig;
import com.eviware.soapui.model.project.Project;

public interface Environment {

    public void setProject(Project project);

    public Project getProject();

    public void release();

    public Service addNewService(String name, ServiceConfig.Type.Enum serviceType);

    public void removeService(Service service);

    public String getName();

    public Property addNewProperty(String name, String value);

    public void removeProperty(Property property);

    public void changePropertyName(String name, String value);

    public void moveProperty(String name, int idx);

    public void setName(String name);

}
