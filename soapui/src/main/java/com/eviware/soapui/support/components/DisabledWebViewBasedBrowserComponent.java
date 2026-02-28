

package com.eviware.soapui.support.components;

import com.eviware.soapui.impl.rest.actions.oauth.BrowserListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

/**
 * @author joel.jonsson
 */
class DisabledWebViewBasedBrowserComponent implements WebViewBasedBrowserComponent {
    private JPanel panel = new JPanel(new BorderLayout());

    DisabledWebViewBasedBrowserComponent() {
        JEditorPane browserDisabledPanel = new JEditorPane();
        browserDisabledPanel.setText("Browser component is disabled.");
        browserDisabledPanel.setEditable(false);
        panel.add(browserDisabledPanel);
        panel.setPreferredSize(new Dimension(300, 200));
    }

    @Override
    public Component getComponent() {
        return panel;
    }

    @Override
    public void navigate(String url) {
    }

    @Override
    public void navigate(String url, String backUpUrl) {
    }

    @Override
    public void setContent(String contentAsString) {
    }

    @Override
    public void setContent(String contentAsString, String contentType) {
    }

    @Override
    public void close(boolean cascade) {
    }

    @Override
    public void addBrowserStateListener(BrowserListener listener) {
    }

    @Override
    public void removeBrowserStateListener(BrowserListener listener) {
    }

    @Override
    public void executeJavaScript(String script) {
    }

    @Override
    public void addJavaScriptEventHandler(String memberName, Object eventHandler) {
    }

    @Override
    public PagePropertyMapper getPagePropertyMapper() {
        return null;
    }
}
