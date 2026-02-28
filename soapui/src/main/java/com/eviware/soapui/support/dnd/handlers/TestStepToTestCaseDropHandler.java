

package com.eviware.soapui.support.dnd.handlers;

import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;

public class TestStepToTestCaseDropHandler extends AbstractBeforeAfterModelItemDropHandler<WsdlTestStep, WsdlTestCase> {
    public TestStepToTestCaseDropHandler() {
        super(WsdlTestStep.class, WsdlTestCase.class);
    }

    @Override
    boolean copyAfter(WsdlTestStep source, WsdlTestCase target) {
        return DragAndDropSupport.copyTestStep(source, target, -1);
    }

    @Override
    boolean moveAfter(WsdlTestStep source, WsdlTestCase target) {
        return DragAndDropSupport.moveTestStep(source, target, -1);
    }

    @Override
    boolean canCopyAfter(WsdlTestStep source, WsdlTestCase target) {
        return true;
    }

    @Override
    boolean canMoveAfter(WsdlTestStep source, WsdlTestCase target) {
        return true;
    }

    @Override
    String getCopyAfterInfo(WsdlTestStep source, WsdlTestCase target) {
        return source.getTestCase() == target ? "Copy TestStep [" + source.getName() + "] within TestCase ["
                + target.getName() + "]" : "Copy TestStep [" + source.getName() + "] to TestCase [" + target.getName()
                + "]";
    }

    @Override
    String getMoveAfterInfo(WsdlTestStep source, WsdlTestCase target) {
        return source.getTestCase() == target ? "Move TestStep [" + source.getName() + "] within TestCase ["
                + target.getName() + "]" : "Move TestStep [" + source.getName() + "] to TestCase [" + target.getName()
                + "]";
    }

    @Override
    boolean canCopyBefore(WsdlTestStep source, WsdlTestCase target) {
        return true;
    }

    @Override
    boolean canMoveBefore(WsdlTestStep source, WsdlTestCase target) {
        return true;
    }

    @Override
    boolean copyBefore(WsdlTestStep source, WsdlTestCase target) {
        return DragAndDropSupport.copyTestStep(source, target, 0);
    }

    @Override
    String getCopyBeforeInfo(WsdlTestStep source, WsdlTestCase target) {
        return getCopyAfterInfo(source, target);
    }

    @Override
    String getMoveBeforeInfo(WsdlTestStep source, WsdlTestCase target) {
        return getMoveAfterInfo(source, target);
    }

    @Override
    boolean moveBefore(WsdlTestStep source, WsdlTestCase target) {
        return DragAndDropSupport.moveTestStep(source, target, 0);
    }
}
