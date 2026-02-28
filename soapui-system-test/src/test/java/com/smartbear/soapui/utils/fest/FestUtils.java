

package com.smartbear.soapui.utils.fest;

import org.assertj.swing.core.Robot;
import org.assertj.swing.exception.ComponentLookupException;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.FrameFixture;

import static org.junit.Assert.fail;

/**
 *
 */
public class FestUtils {
    public static void verifyDialogIsNotShowing(String dialogName, Robot robot) {
        try {
            findDialog(dialogName, robot);
            fail("Dialog: " + dialogName + " is still visible");
        } catch (ComponentLookupException e) {
        }
    }

    public static DialogFixture findDialog(String dialogName, Robot robot) {
        return new DialogFixture(robot, dialogName);
    }

    public static void verifyButtonIsNotShowing(FrameFixture rootWindow, String buttonName) {
        try {
            rootWindow.button(buttonName);
            fail("Button: " + buttonName + " is still visible");
        } catch (ComponentLookupException e) {
        }
    }

    public static void verifyTextFieldIsNotShowingInDialog(DialogFixture rootWindow, String fieldName) {
        try {
            rootWindow.textBox(fieldName);
            fail("Text field: " + fieldName + " is still visible");
        } catch (ComponentLookupException e) {
        }
    }
}
