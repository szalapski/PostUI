

package com.eviware.x.form.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A field in an AForm
 *
 * @author ole.matzura
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AField {
    public enum AFieldType {
        BOOLEAN, STRING, FILE, FOLDER, FILE_OR_FOLDER, INT, ENUMERATION, PASSWORD, FILELIST, RADIOGROUP, STRINGAREA,
        MULTILIST, STRINGLIST, TABLE, ACTION, COMPONENT, SEPARATOR, INFORMATION, LABEL, RADIOGROUP_TOP_BUTTON, COMBOBOX
    }

    public String name() default "";

    public String description();

    public AFieldType type() default AFieldType.STRING;

    public String group() default "";

    public String[] values() default "";

    public String defaultValue() default "";

    boolean enabled() default true;
}
