

package com.eviware.x.impl.swing;

import com.eviware.soapui.support.action.swing.ActionList;
import com.eviware.soapui.support.action.swing.DefaultActionList;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class JWizardDialogBuilder extends SwingXFormDialogBuilder {
    private SwingXFormDialog dialog;

    public JWizardDialogBuilder(String name) {
        super(name);
    }

    protected final class NextAction extends AbstractAction {
        public NextAction() {
            super("Next");
        }

        public void actionPerformed(ActionEvent e) {
            if (dialog != null) {
                // dialog.setReturnValue( XFormDialog.NEXT_OPTION );
                dialog.setVisible(false);
            }
        }
    }

    public ActionList buildprevNextCancelActions() {
        DefaultActionList actions = new DefaultActionList("Actions");
        actions.addAction(new NextAction());
        actions.addAction(new CancelAction());
        return actions;
    }
}
