

package com.eviware.soapui.security.boundary;

import java.text.SimpleDateFormat;

/**
 * @author nebojsa.tasic
 */
public class DateBoundary extends AbstractBoundary {

    private static final int OFFSET = 10;
    public static final String DATE_FORMAT = "yyyy-MM-dd'T00:00:00'";

    private static final ThreadLocal<SimpleDateFormat> simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };

    @Override
    public String outOfBoundary(int restrictionAttribute, String value) {
        switch (restrictionAttribute) {
            case MAX_EXCLISIVE:
                return BoundaryUtils.createDate(value, (int) (Math.random() * OFFSET), simpleDateFormat.get());
            case MIN_EXCLISIVE:
                return BoundaryUtils.createDate(value, -(int) (Math.random() * OFFSET), simpleDateFormat.get());
            case MAX_INCLISIVE:
                return BoundaryUtils.createDate(value, (int) (Math.random() * OFFSET + 1), simpleDateFormat.get());
            case MIN_INCLISIVE:
                return BoundaryUtils.createDate(value, (-(int) (Math.random() * OFFSET) - 1), simpleDateFormat.get());
            default:
                return null;
        }
    }

}
