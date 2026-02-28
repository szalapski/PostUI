

package com.eviware.soapui.impl.wsdl.actions.iface.tools.support;

import com.eviware.soapui.support.types.StringToStringMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgumentBuilderTest {

    @Test
    public void testUnix() throws Exception {
        ArgumentBuilder builder = new ArgumentBuilder(new StringToStringMap());
        builder.startScript("tcpmon", null, ".sh");

        assertEquals("sh", builder.getArgs().get(0));
        assertEquals("-c", builder.getArgs().get(1));

        assertEquals("./tcpmon.sh", builder.getArgs().get(2));

        builder.addArgs(new String[]{"test"});
        assertEquals("./tcpmon.sh test", builder.getArgs().get(2));

        builder.addArgs(new String[]{"te st"});
        assertEquals("./tcpmon.sh test te%20st", builder.getArgs().get(2));
    }
}
