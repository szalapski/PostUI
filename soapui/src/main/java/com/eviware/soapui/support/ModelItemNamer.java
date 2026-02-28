

package com.eviware.soapui.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.types.StringList;

import javax.annotation.Nonnull;

/**
 * Utility class to create unique names for model items
 * <p/>
 * Creates a new name from the baseName and the next available number.
 * <p/>
 * Example:
 * Given
 * baseName: "Project"
 * items: "Project 1", "Project 2", "Project 3", "Project 5"
 * Then
 * Returns the name "Project 6"
 *
 * @author Anders Jaensson
 * @author Prakash Jat
 */
public class ModelItemNamer {
    private ModelItemNamer() {
    }

    public static String createName(String baseName, Iterable nameHolders) {
        int maxExistingIndex = 0;
        for (Object nameHolder : nameHolders) {
            if (nameHolder == null) {
                continue;
            }
            String name = getName(nameHolder);
            if (name.contains(baseName)) {
                try {
                    int beginIndex = name.indexOf(baseName) + baseName.length();
                    int indexInProjectName = Integer.parseInt(name.substring(beginIndex).trim());
                    if (indexInProjectName > maxExistingIndex) {
                        maxExistingIndex = indexInProjectName;
                    }
                } catch (Exception e) {
                    //Do nothing, at worst it will create the modelItem with same name
                }
            }
        }

        return baseName + " " + (++maxExistingIndex);
    }

    public static boolean isUnique(String baseName, Iterable nameHolders) {
        for (Object nameHolder : nameHolders) {
            if (nameHolder == null) {
                continue;
            }
            String name = getName(nameHolder);
            if (baseName.equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static String getUniqueName(String def, ModelItem parent) {
        final StringList childrenNames = getChildrenNames(parent);
        return createName(def, childrenNames);
    }

    private static StringList getChildrenNames(ModelItem parent) {
        StringList names = new StringList();
        for (ModelItem item : parent.getChildren()) {
            names.add(item.getName());
        }
        return names;
    }

    private static String getName(@Nonnull Object nameHolder) {
        return nameHolder instanceof ModelItem ? ((ModelItem) nameHolder).getName() : nameHolder.toString();
    }
}
