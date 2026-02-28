

package com.eviware.soapui.model.testsuite;

/**
 * @author Erik R. Yverling
 *         <p/>
 *         Used to get the current value of a Test property without evaluating a
 *         new value.
 */
public interface EvaluatedOnReadTestProperty {
    String getCurrentValue();
}
