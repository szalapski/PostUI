

package com.eviware.x.form;

public class ValidationMessage {
    private String message;
    private XFormField formField;

    public ValidationMessage(String message, XFormField formField) {
        super();
        this.message = message;
        this.formField = formField;
    }

    public XFormField getFormField() {
        return formField;
    }

    public String getMessage() {
        return message;
    }

    public void setFormField(XFormField formField) {
        this.formField = formField;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
