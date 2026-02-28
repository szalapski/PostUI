

package com.eviware.soapui.tools;

import org.apache.logging.log4j.Logger;

public interface CmdLineRunner {
    public String getProjectFile();

    public String getSettingsFile();

    public String getOutputFolder();

    public Logger getLog();

    public String[] getProjectProperties();
}
