

package com.eviware.soapui.impl.actions;

public class LabeledItem<T extends Labeled> {


    private final Labeled value;

    LabeledItem(Labeled value) {
        this.value = value;
    }

    Labeled getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getLabel();
    }

}
