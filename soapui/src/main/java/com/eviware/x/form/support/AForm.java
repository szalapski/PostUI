

package com.eviware.x.form.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Form Annotation for use with ADialogBuilder
 *
 * @author ole.matzura
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AForm {
    public String name();

    public String description();

    public String helpUrl() default "";

    public String icon() default "";
}
