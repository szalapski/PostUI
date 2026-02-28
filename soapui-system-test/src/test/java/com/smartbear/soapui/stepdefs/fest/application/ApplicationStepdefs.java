
package com.smartbear.soapui.stepdefs.fest.application;

import com.eviware.soapui.support.ConsoleDialogs;
import com.eviware.soapui.support.UISupport;
import com.smartbear.soapui.stepdefs.fest.ScenarioRobot;
import com.smartbear.soapui.utils.fest.ApplicationUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;

import static com.smartbear.soapui.utils.fest.ApplicationUtils.closeApplicationWithoutSaving;
import static com.smartbear.soapui.utils.fest.ApplicationUtils.getMainWindow;

public class ApplicationStepdefs {
    private Robot robot;

    public ApplicationStepdefs(ScenarioRobot runner) {
        robot = runner.getRobot();
    }

    @Before
    public void startSoapUI() {
        ApplicationUtils.startSoapUI();
    }

    @After
    public void closeSoapUIIfRunning() {
        try {
            FrameFixture mainWindow = getMainWindow(robot);
            if (mainWindow != null) {
                closeApplicationWithoutSaving(mainWindow, robot);
            }
        } catch (Exception e) {
            //Most probably SoapUI is not running.
        }
        robot.cleanUp();
        UISupport.setDialogs(new ConsoleDialogs());
    }
}