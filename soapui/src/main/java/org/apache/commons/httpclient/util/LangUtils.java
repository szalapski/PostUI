/*
 * $HeadURL: https://svn.apache.org/repos/asf/jakarta/httpcomponents/oac.hc3x/tags/HTTPCLIENT_3_1/src/java/org/apache/commons/httpclient/util/LangUtils.java $
 * $Revision: 480424 $
 * $Date: 2006-11-29 06:56:49 +0100 (Wed, 29 Nov 2006) $

 */

package org.apache.commons.httpclient.util;

/**
 * A set of utility methods to help produce consistent Object#equals(Object) and
 * Object#hashCode methods.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * @since 3.0
 */
public class LangUtils {

    public static final int HASH_SEED = 17;
    public static final int HASH_OFFSET = 37;

    private LangUtils() {
        super();
    }

    public static int hashCode(final int seed, final int hashcode) {
        return seed * HASH_OFFSET + hashcode;
    }

    public static int hashCode(final int seed, final Object obj) {
        return hashCode(seed, obj != null ? obj.hashCode() : 0);
    }

    public static int hashCode(final int seed, final boolean b) {
        return hashCode(seed, b ? 1 : 0);
    }

    public static boolean equals(final Object obj1, final Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }

}
