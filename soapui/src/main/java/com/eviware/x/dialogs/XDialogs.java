

package com.eviware.x.dialogs;

import java.awt.Component;
import java.awt.Dimension;

/**
 * @author Lars
 */

public interface XDialogs {
    void showErrorMessage(String message);

    void showInfoMessage(String message);

    void showInfoMessage(String message, String title);

    void showExtendedInfo(String title, String description, String content, Dimension size);

    boolean confirm(String question, String title);

    boolean confirm(String question, String title, Component parent);

    Boolean confirmOrCancel(String question, String title);

    int yesYesToAllOrNo(String question, String title);

    String prompt(String question, String title, String value);

    String prompt(String question, String title);

    Object prompt(String question, String title, Object[] objects);

    Object prompt(String question, String title, Object[] objects, String value);

    char[] promptPassword(String question, String title);

    XProgressDialog createProgressDialog(String label, int length, String initialValue, boolean canCancel);

    boolean confirmExtendedInfo(String title, String description, String content, Dimension size);

    Boolean confirmOrCancleExtendedInfo(String title, String description, String content, Dimension size);

    String selectXPath(String title, String info, String xml, String xpath);

    String selectJsonPath(String title, String info, String json, String jsonPath);
}
