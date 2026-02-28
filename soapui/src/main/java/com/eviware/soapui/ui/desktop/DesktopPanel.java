

package com.eviware.soapui.ui.desktop;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.PropertyChangeNotifier;

import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * Behaviour for a SoapUI desktop panel
 *
 * @author Ole.Matzura
 */

public interface DesktopPanel extends PropertyChangeNotifier {
    public final static String TITLE_PROPERTY = DesktopPanel.class.getName() + "@title";
    public final static String ICON_PROPERTY = DesktopPanel.class.getName() + "@icon";

    /**
     * Gets the title for this desktop panel
     */

    public String getTitle();

    /**
     * Gets the description for this desktop panel.. may be used as tooltip,
     * etc..
     *
     * @return
     */

    public String getDescription();

    /**
     * Gets the model item associated with this desktop panel
     */

    public ModelItem getModelItem();

    /**
     * Called when a desktop panel is about to be closed, may be overriden
     * (depending on situation) by returning false if canCancel is set to true.
     */

    public boolean onClose(boolean canCancel);

    /**
     * Gets the component used to display this desktop panel
     */

    public JComponent getComponent();

    /**
     * Checks if this desktop panel depends on the existence of the specified
     * model item, used for closing relevant panels.
     *
     * @param modelItem
     */

    public boolean dependsOn(ModelItem modelItem);

    /**
     * Returns the icon for this panel
     */

    public Icon getIcon();
}
