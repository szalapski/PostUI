
package com.smartbear.soapui.utils.fest;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.project.Project;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JPopupMenuFixture;
import org.assertj.swing.fixture.JTreeFixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class used for generic operations on the workspace level
 */
public final class WorkspaceUtils {
    public static final String NAVIGATION_TREE_PATH_SEPARATOR = "##";
    private static final String NAVIGATOR = "navigator";

    private WorkspaceUtils() {
        throw new AssertionError();
    }

    public static JPanelFixture getNavigatorPanel(FrameFixture frame) {
        return frame.panel(NAVIGATOR);
    }

    public static JPopupMenuFixture rightClickOnWorkspace(FrameFixture frame) {
        return getNavigatorPanel(frame).tree().showPopupMenuAt(SoapUI.getWorkspace().getName());
    }

    public static List<String> getProjectNameList() {
        List<String> projectNameList = new ArrayList<String>();
        for (Project project : SoapUI.getWorkspace().getProjectList()) {
            projectNameList.add(project.getName());
        }
        Collections.sort(projectNameList);
        return projectNameList;
    }

    public static JTreeFixture getNavigationTree(FrameFixture rootWindow) {
        JTreeFixture navigationTree = getNavigatorPanel(rootWindow).tree();
        navigationTree.replaceSeparator("##");
        return navigationTree;
    }

    public static String getProjectNavigationPath(String projectName) {
        return SoapUI.getWorkspace().getName() + NAVIGATION_TREE_PATH_SEPARATOR + projectName
                + NAVIGATION_TREE_PATH_SEPARATOR;
    }
}