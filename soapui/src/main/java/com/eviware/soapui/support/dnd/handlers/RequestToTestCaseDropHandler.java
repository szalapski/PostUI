

package com.eviware.soapui.support.dnd.handlers;

import com.eviware.soapui.impl.support.AbstractHttpRequest;
import com.eviware.soapui.impl.wsdl.actions.request.AbstractAddRequestToTestCaseAction;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;

public class RequestToTestCaseDropHandler extends AbstractCopyingModelItemDropHandler<AbstractHttpRequest, WsdlTestCase> {
    public RequestToTestCaseDropHandler() {
        super(AbstractHttpRequest.class, WsdlTestCase.class);
    }

    @Override
    boolean canCopyBefore(AbstractHttpRequest source, WsdlTestCase target) {
        return false;
    }

    @Override
    boolean canCopyOn(AbstractHttpRequest source, WsdlTestCase target) {
        return true;
    }

    @Override
    boolean canCopyAfter(AbstractHttpRequest source, WsdlTestCase target) {
        return true;
    }

    @Override
    boolean copyBefore(AbstractHttpRequest source, WsdlTestCase target) {
        return false;
    }

    @Override
    boolean copyOn(AbstractHttpRequest source, WsdlTestCase target) {
        return addRequestToTestCase(source, target);
    }

    @Override
    boolean copyAfter(AbstractHttpRequest source, WsdlTestCase target) {
        return addRequestToTestCase(source, target);
    }

    private boolean addRequestToTestCase(AbstractHttpRequest source, WsdlTestCase target) {
        return AbstractAddRequestToTestCaseAction.addRequestToTestCase(source, target, 0);
    }

    @Override
    String getCopyBeforeInfo(AbstractHttpRequest source, WsdlTestCase target) {
        return null;
    }

    @Override
    String getCopyOnInfo(AbstractHttpRequest source, WsdlTestCase target) {
        return getCopyAfterInfo(source, target);
    }

    @Override
    String getCopyAfterInfo(AbstractHttpRequest source, WsdlTestCase target) {
        return "Add Request [" + source.getName() + "] to TestCase [" + target.getName() + "]";
    }
}
