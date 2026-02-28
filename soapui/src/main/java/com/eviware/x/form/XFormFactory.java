

package com.eviware.x.form;

public abstract class XFormFactory {
    public static XFormDialogBuilder createDialogBuilder(String name) {
        return Factory.instance.createDialogBuilder2(name);
    }

    public static class Factory {
        public static XFormFactory instance;
    }

    public abstract XFormDialogBuilder createDialogBuilder2(String name);
}
