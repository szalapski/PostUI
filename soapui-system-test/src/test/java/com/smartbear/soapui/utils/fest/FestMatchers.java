
package com.smartbear.soapui.utils.fest;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.finder.DialogFinder;
import org.assertj.swing.finder.FrameFinder;

import javax.swing.*;
import java.awt.*;

import static org.assertj.swing.finder.WindowFinder.findDialog;
import static org.assertj.swing.finder.WindowFinder.findFrame;

/**
 * @author Prakash
 */
public final class FestMatchers {
    private FestMatchers() {
        throw new AssertionError();
    }

    public static FrameFinder frameWithTitle(final String expectedTitle) {
        return findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            @Override
            protected boolean isMatching(Frame component) {
                return doesStringStartWith(component.getTitle(), expectedTitle);
            }
        });
    }

    public static DialogFinder dialogWithTitle(final String expectedTitle) {
        return findDialog(new GenericTypeMatcher<JDialog>(JDialog.class) {
            @Override
            protected boolean isMatching(JDialog component) {
                return doesStringStartWith(component.getTitle(), expectedTitle);
            }
        });
    }

    public static GenericTypeMatcher<JButton> buttonWithText(final String expectedText) {
        return new GenericTypeMatcher<JButton>(JButton.class) {
            @Override
            protected boolean isMatching(JButton button) {
                return doesStringStartWith(button.getText(), expectedText);
            }
        };
    }

    public static GenericTypeMatcher<JMenuItem> menuItemWithText(final String expectedText) {
        return new GenericTypeMatcher<JMenuItem>(JMenuItem.class) {
            @Override
            protected boolean isMatching(JMenuItem menuItem) {
                return doesStringStartWith(menuItem.getText(), expectedText);
            }
        };
    }

    private static boolean doesStringStartWith(String mainString, String subString) {
        return mainString == subString || (mainString != null && subString != null &&
                mainString.startsWith(subString));
    }
}
