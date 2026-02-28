

package com.eviware.soapui.security.boundary;

/**
 * @author nebojsa.tasic
 */
public class StringBoundary extends AbstractBoundary {
    public static final String AVAILABLE_VALUES = " abcdefghijklmnopqrstuvwxyz\n\t\r";

    @Override
    public String outOfBoundary(int restrictionAttribute, String value) {
        switch (restrictionAttribute) {
            case LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value));
            case MIN_LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) - 1);
            case MAX_LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) + 1);
            default:
                return null;
        }
    }
}
