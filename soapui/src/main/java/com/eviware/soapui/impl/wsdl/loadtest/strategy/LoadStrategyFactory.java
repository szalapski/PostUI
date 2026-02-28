

package com.eviware.soapui.impl.wsdl.loadtest.strategy;

import com.eviware.soapui.impl.wsdl.loadtest.WsdlLoadTest;
import org.apache.xmlbeans.XmlObject;

/**
 * Factory for LoadStrategies
 *
 * @author Ole.Matzura
 */

public interface LoadStrategyFactory {
    public String getType();

    public LoadStrategy build(XmlObject config, WsdlLoadTest loadTest);

    public LoadStrategy create(WsdlLoadTest loadTest);
}
