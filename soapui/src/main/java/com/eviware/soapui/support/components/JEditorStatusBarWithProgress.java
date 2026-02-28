

package com.eviware.soapui.support.components;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import java.awt.Color;

public class JEditorStatusBarWithProgress extends JEditorStatusBar {
    private JProgressBar progressBar;

    public JEditorStatusBarWithProgress() {
        super();

        initProgressBar();
    }

    private void initProgressBar() {
        progressBar = new JProgressBar();
        progressBar.setBackground(Color.WHITE);
        progressBar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2, 2, 2, 3),
                BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY)));

        setStatusComponent(progressBar);
    }

    public JEditorStatusBarWithProgress(JEditorStatusBarTarget target) {
        super(target);

        initProgressBar();
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setIndeterminate(boolean newValue) {
        progressBar.setIndeterminate(newValue);
    }

    public void setValue(int n) {
        progressBar.setValue(n);
    }
}
