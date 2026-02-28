

package com.eviware.soapui.model.support;

import com.eviware.soapui.model.testsuite.TestPropertyListener;

/**
 * Adapter for TestPropertyListener implementations
 *
 * @author ole.matzura
 */

public class TestPropertyListenerAdapter implements TestPropertyListener {
    public void propertyAdded(String name) {
    }

    public void propertyRemoved(String name) {
    }

    public void propertyRenamed(String oldName, String newName) {
    }

    public void propertyValueChanged(String name, String oldValue, String newValue) {
    }

    public void propertyMoved(String name, int oldIndex, int newIndex) {
    }
}
