

package com.eviware.soapui.settings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Setting {
    public enum SettingType {
        BOOLEAN, STRING, FILE, FOLDER, INT, ENUMERATION, PASSWORD, CUSTOM, FILELIST, STRINGLIST
    }

    public String name();

    public String description();

    public SettingType type() default SettingType.STRING;

    public String[] values() default "";

    public String defaultValue() default "";

    public Class<? extends SettingHandler> customHandler() default SettingHandler.class;
}
