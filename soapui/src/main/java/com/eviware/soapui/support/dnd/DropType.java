

package com.eviware.soapui.support.dnd;

public interface DropType {
    public final static int BEFORE = 1;
    public final static int AFTER = 2;
    public final static int ON = 4;
    public static final int NONE = 0;
    public static final int BEFORE_AND_AFTER = BEFORE + AFTER;
}
