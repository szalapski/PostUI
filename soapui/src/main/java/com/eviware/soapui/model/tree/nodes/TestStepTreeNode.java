

package com.eviware.soapui.model.tree.nodes;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.tree.SoapUITreeModel;

/**
 * SoapUITreeNode for TestStep implementations
 *
 * @author Ole.Matzura
 */

public class TestStepTreeNode extends PropertiesTreeNode<TestStep> {
    public TestStepTreeNode(TestStep testStep, ModelItem parent, SoapUITreeModel treeModel) {
        super(testStep, parent, testStep, treeModel);
    }
}
