

package com.eviware.x.form;

import com.eviware.soapui.support.action.swing.ActionList;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.ImageIcon;
import java.util.ArrayList;

public abstract class XFormDialogBuilder {
    private ArrayList<XForm> forms = new ArrayList<>();

    public XFormDialogBuilder() {
    }

    protected void addForm(XForm form) {
        forms.add(form);
    }

    protected XForm[] getForms() {
        return forms.toArray(new XForm[forms.size()]);
    }

    public abstract XForm createForm(String name);

    public abstract XFormDialog buildDialog(ActionList actions, String description, ImageIcon icon);

    public abstract XFormDialog buildWizard(String description, ImageIcon icon, String helpURL);

    public abstract ActionList buildOkCancelActions();

    public abstract ActionList buildOkCancelHelpActions(String url);

    public abstract ActionList buildHelpActions(String url);

    public XForm createForm(String name, FormLayout layout) {
        return createForm(name);
    }
}
