

package com.eviware.soapui.security.boundary;

/**
 * @author nebojsa.tasic
 */
public class DecimalBoundary extends AbstractBoundary {
    private static final String DECIMAL_POINT = ".";
    private static final String AVAILABLE_VALUES = "1234567890";

    @Override
    public String outOfBoundary(int restrictionAttribute, String value) {
        switch (restrictionAttribute) {
            case LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value));
            case MIN_LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) - 1);
            case MAX_LENGTH:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) + 1);
            case TOTAL_DIGITS:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) + 1);
            case FRACTION_DIGITS:
                return BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, 1) + DECIMAL_POINT
                        + BoundaryUtils.createCharacterArray(AVAILABLE_VALUES, Integer.valueOf(value) + 1);
            default:
                return null;
        }
    }
}
