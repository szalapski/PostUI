

package com.eviware.x.impl.swing;

import com.eviware.x.form.XFormDialogBuilder;
import com.eviware.x.form.XFormFactory;

/**
 * @author lars
 */
public class SwingFormFactory extends XFormFactory {
    public XFormDialogBuilder createDialogBuilder2(String name) {
        return new SwingXFormDialogBuilder(name);
    }
}
