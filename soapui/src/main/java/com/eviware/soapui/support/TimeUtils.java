

package com.eviware.soapui.support;

public final class TimeUtils {
    private TimeUtils() {
    }

    public static long getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
