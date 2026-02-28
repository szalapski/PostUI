

package com.eviware.soapui.model.testsuite;

import com.eviware.soapui.support.editor.xml.support.ValidationError;
import org.apache.xmlbeans.XmlError;

/**
 * Holder for an assertion error
 *
 * @author Ole.Matzura
 */

public class AssertionError implements ValidationError {
    private String message;
    private XmlError xmlError;

    public AssertionError(String message) {
        this.message = message;
    }

    public AssertionError(XmlError xmlError) {
        this.xmlError = xmlError;
        this.message = xmlError.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public int getLineNumber() {
        return xmlError == null ? -1 : xmlError.getLine();
    }

    public XmlError getXmlError() {
        return xmlError;
    }

    public String toString() {
        if (xmlError == null) {
            return message;
        }

        return "line " + getLineNumber() + ": " + message;
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        String msg = toString();
        result = PRIME * result + ((msg == null) ? 0 : msg.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssertionError other = (AssertionError) obj;

        return other.toString().equals(toString());
    }
}
