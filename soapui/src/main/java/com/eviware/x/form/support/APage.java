

package com.eviware.x.form.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A page in a wizard
 *
 * @author Lars
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface APage {
    /**
     * The name of this page.
     */
    public String name();
}
