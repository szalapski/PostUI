

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.types.StringToObjectMap;

public interface TestRunnable extends ModelItem {
    public TestRunner run(StringToObjectMap context, boolean async);
}
