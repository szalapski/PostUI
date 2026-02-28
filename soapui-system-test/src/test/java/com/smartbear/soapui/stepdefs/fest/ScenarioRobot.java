
package com.smartbear.soapui.stepdefs.fest;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;

/**
 * A wapper for an AWT robot that's instantiated once per scenario and passed to  stepDefs using constructor injection
 */
public final class ScenarioRobot {
    private final Robot robot;

    public ScenarioRobot() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
    }

    public Robot getRobot() {
        return robot;
    }
}