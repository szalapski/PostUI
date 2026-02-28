

package com.eviware.soapui.model.util;

import com.eviware.soapui.model.ModelItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility for handling model item names.
 *
 * @author Lars Höidahl
 */

public class ModelItemNames<T extends ModelItem> {
    private List<T> elements;

    public ModelItemNames(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public ModelItemNames(T[] elements) {
        // Create an ArrayList to make sure that elements is modifyable.
        this.elements = new ArrayList<>(Arrays.asList(elements));
    }

    public String[] getNames() {
        ArrayList<String> list = getElementNameList();
        return list.toArray(new String[list.size()]);
    }

    private ArrayList<String> getElementNameList() {
        ArrayList<String> elementNames = new ArrayList<>();
        for (T element : elements) {
            elementNames.add(element.getName());
        }
        return elementNames;
    }

    public T getElement(String name) {
        int index = getElementNameList().indexOf(name);
        return elements.get(index);
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public int getSize() {
        return elements.size();
    }

    public String getNameAt(int i) {
        return elements.get(i).getName();
    }
}
