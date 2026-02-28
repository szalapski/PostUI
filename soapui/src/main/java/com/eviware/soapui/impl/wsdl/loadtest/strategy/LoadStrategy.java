

package com.eviware.soapui.impl.wsdl.loadtest.strategy;

import com.eviware.soapui.model.testsuite.LoadTestRunContext;
import com.eviware.soapui.model.testsuite.LoadTestRunListener;
import com.eviware.soapui.model.testsuite.LoadTestRunner;
import org.apache.xmlbeans.XmlObject;

import javax.swing.JComponent;
import java.beans.PropertyChangeListener;

/**
 * Strategy used by WsdlLoadTest for controlling requests in each thread
 *
 * @author Ole.Matzura
 */

public interface LoadStrategy extends LoadTestRunListener {
    public final static String CONFIGURATION_PROPERTY = "configuration_property";

    public void addConfigurationChangeListener(PropertyChangeListener listener);

    public void removeConfigurationChangeListener(PropertyChangeListener listener);

    public XmlObject getConfig();

    public String getType();

    public JComponent getConfigurationPanel();

    public void updateConfig(XmlObject config);

    public boolean allowThreadCountChangeDuringRun();

    public void recalculate(LoadTestRunner loadTestRunner, LoadTestRunContext context);
}
