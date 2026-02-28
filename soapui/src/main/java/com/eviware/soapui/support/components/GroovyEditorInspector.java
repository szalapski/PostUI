

package com.eviware.soapui.support.components;

public class GroovyEditorInspector extends JComponentInspector<GroovyEditorComponent> {
    public GroovyEditorInspector(GroovyEditorComponent component, String title, String description) {
        super(component, title, description, true);
    }

    @Override
    public void activate() {
        getComponent().getEditor().requestFocusInWindow();
    }
}
