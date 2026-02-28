
package com.eviware.soapui.support.log;

import com.eviware.soapui.SoapUI;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

/**
 * Log4j appender thats appends to SoapUI log panel
 */

@Plugin(name = "SOAPUI", category = "Core", elementType = "appender")
public class SoapUIAppender extends AbstractAppender {
    public SoapUIAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    @Override
    public void append(LogEvent event) {
        SoapUI.log(event);
    }

    @PluginFactory
    @SuppressWarnings("unused")
    public static SoapUIAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter) {

        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new SoapUIAppender(name, filter, layout);
    }
}
