

package com.eviware.soapui.impl.wsdl.loadtest.log;

import com.eviware.soapui.support.action.swing.ActionList;

import javax.swing.ImageIcon;
import java.io.IOException;

/**
 * An entry in the loadtest log
 *
 * @author Ole.Matzura
 */

public interface LoadTestLogEntry {
    public String getMessage();

    public long getTimeStamp();

    public String getType();

    public String getTargetStepName();

    public ActionList getActions();

    public ImageIcon getIcon();

    public boolean isError();

    public void discard();

    public boolean isDiscarded();

    public void exportToFile(String fileName) throws IOException;
}
