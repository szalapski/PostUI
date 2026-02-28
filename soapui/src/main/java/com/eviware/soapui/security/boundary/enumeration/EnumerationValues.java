

package com.eviware.soapui.security.boundary.enumeration;

import com.eviware.soapui.security.boundary.BoundaryUtils;
import com.eviware.soapui.security.boundary.StringBoundary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnumerationValues {
    private String type;
    private List<String> valuesList = new ArrayList<>();

    public EnumerationValues(String type) {
        this.type = type;
    }

    public static int maxLengthStringSize(Collection<String> values) {
        int max = 0;
        for (String str : values) {
            if (max < str.length()) {
                max = str.length();
            }
        }
        return max;
    }

    public static String createOutOfBoundaryValue(EnumerationValues enumValues, int size) {
        if ("XmlString".equals(enumValues.getType())) {
            String value = null;
            do {
                value = BoundaryUtils.createCharacterArray(StringBoundary.AVAILABLE_VALUES, size);
            }
            while (enumValues.getValuesList().contains(value));
            return value;
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void addValue(String value) {
        valuesList.add(value);
    }

    public List<String> getValuesList() {
        return valuesList;
    }

}
