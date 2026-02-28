

package com.eviware.soapui.impl.wsdl.teststeps.assertions.recent;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.panels.assertions.AssertionListEntry;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.TestAssertionRegistry;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.settings.RecentAssertionSettings;
import com.eviware.soapui.support.types.StringList;

import java.util.List;

public class RecentAssertionHandler {
    private BoundedQueue bq;

    public RecentAssertionHandler() {
        bq = new BoundedQueue();
        for (String el : load()) {
            bq.add(el);
        }
    }

    public String getAssertionTypeByName(String name) {
        String type = TestAssertionRegistry.getInstance().getAssertionTypeForName(name);

        if (type == null) {
            this.bq.remove(name);
            save();
        }

        return type;
    }

    public boolean canAssert(String type, Assertable assertable) {
        return TestAssertionRegistry.getInstance().canAssert(type, assertable);
    }

    public AssertionListEntry getAssertionListEntry(String type) {
        return TestAssertionRegistry.getInstance().getAssertionListEntry(type);
    }

    public void add(String assertion) {
        this.bq.add(assertion);
        save();
    }

    public List<String> get() {
        return this.bq.getByAlphabeticalOrder();
    }

    private void save() {
        StringList list = new StringList();
        list.addAll(this.bq.getByInsertionOrder());
        SoapUI.getSettings().setString(RecentAssertionSettings.RECENT_ASSERTIONS, list.toXml());
    }

    private StringList load() {
        StringList list = new StringList();
        String temp = SoapUI.getSettings().getString(RecentAssertionSettings.RECENT_ASSERTIONS, null);
        if (temp != null && temp.trim().length() > 0) {
            try {
                StringList assertions = StringList.fromXml(temp);
                for (String assertion : assertions) {
                    list.add(assertion);
                }
            } catch (Exception e) {
                SoapUI.logError(e);
            }
        }
        return list;
    }
}
