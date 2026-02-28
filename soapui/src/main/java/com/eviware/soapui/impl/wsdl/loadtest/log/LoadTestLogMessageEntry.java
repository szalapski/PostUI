

package com.eviware.soapui.impl.wsdl.loadtest.log;

import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.swing.ActionList;

import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A simple message LoadTest Log entry
 *
 * @author Ole.Matzura
 */

public class LoadTestLogMessageEntry implements LoadTestLogEntry {
    private final String message;
    private long timestamp;
    private ImageIcon icon;
    private boolean discarded;

    public LoadTestLogMessageEntry(String message) {
        this.message = message;
        timestamp = System.currentTimeMillis();

        icon = UISupport.createImageIcon("/loadtest_log_message.gif");
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timestamp;
    }

    public String getTargetStepName() {
        return null;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public String getType() {
        return "Message";
    }

    public boolean isError() {
        return false;
    }

    public ActionList getActions() {
        return null;
    }

    public void exportToFile(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.write(new Date(timestamp).toString());
        writer.write(":");
        writer.write(message);
        writer.close();
    }

    public void discard() {
        discarded = true;
    }

    public boolean isDiscarded() {
        return discarded;
    }
}
