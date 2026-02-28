

package com.eviware.soapui.security.boundary;

/**
 * @author nebojsa.tasic
 */
public interface Boundary {
    public static final int LENGTH = 1;
    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 3;
    public static final int TOTAL_DIGITS = 4;
    public static final int FRACTION_DIGITS = 5;
    public static final int MAX_EXCLISIVE = 6;
    public static final int MIN_EXCLISIVE = 7;
    public static final int MAX_INCLISIVE = 8;
    public static final int MIN_INCLISIVE = 9;

    String outOfBoundary(int restrictionAttribute, String value);
}
