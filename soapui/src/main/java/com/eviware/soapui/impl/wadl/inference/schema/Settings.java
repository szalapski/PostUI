

package com.eviware.soapui.impl.wadl.inference.schema;

/**
 * Static class containing package global variables.
 *
 * @author Dain Nilsson
 */
public class Settings {

    /**
     * Locality used for iLOCAL algorithm when inferring complex types.
     */
    public static final int locality = 2;

    /**
     * The namespace for XML Schema.
     */
    public static final String xsdns = "http://www.w3.org/2001/XMLSchema";

    /**
     * The namespace for XML Schema-instance.
     */
    public static final String xsins = "http://www.w3.org/2001/XMLSchema-instance";
}
