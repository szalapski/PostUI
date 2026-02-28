
package com.eviware.soapui.ui;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.components.WebViewBasedBrowserComponent;
import com.eviware.soapui.support.components.WebViewBasedBrowserComponentFactory;
import com.eviware.soapui.ui.starterpage.StarterPageButtonCallback;
import com.eviware.soapui.ui.support.DefaultDesktopPanel;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

public class URLDesktopPanel extends DefaultDesktopPanel {
    private WebViewBasedBrowserComponent browser;
    private boolean closed;
    private String lastBackupUrl = null;

    public URLDesktopPanel(String title, String description, String url, String backupUrl) throws InterruptedException,
            InvocationTargetException {
        super(title, description, new JPanel(new BorderLayout()));

        JPanel panel = (JPanel) getComponent();

        browser = WebViewBasedBrowserComponentFactory.createBrowserComponent(false, WebViewBasedBrowserComponent.PopupStrategy.EXTERNAL_BROWSER);
        browser.addJavaScriptEventHandler(StarterPageButtonCallback.CALLBACK, new StarterPageButtonCallback(SoapUI.getWorkspace()));
        //browser.addJavaScriptEventHandler("templateProjectCreator", new TemplateProjectCreator());

        panel.add(browser.getComponent(), BorderLayout.CENTER);

        if (StringUtils.hasContent(url)) {
            navigate(url, backupUrl, true);
        }
    }

    public void navigate(String url, String errorUrl, boolean async) {
        lastBackupUrl = errorUrl;
        if (async) {
            SwingUtilities.invokeLater(new Navigator(url, errorUrl));
        } else {
            browser.navigate(url);
        }
    }

    public boolean onClose(boolean canCancel) {
        browser.close(true);
        closed = true;
        return super.onClose(canCancel);
    }

    public boolean isClosed() {
        return closed;
    }

    protected WebViewBasedBrowserComponent getBrowser() {
        return browser;
    }

    private class Navigator implements Runnable {
        private final String url;
        private final String backupUrl;

        public Navigator(String url, String backupUrl) {
            this.url = url;
            this.backupUrl = backupUrl;
        }

        public void run() {
            browser.navigate(url, backupUrl);
        }
    }

}
