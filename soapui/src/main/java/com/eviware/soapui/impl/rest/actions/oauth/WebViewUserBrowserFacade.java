

package com.eviware.soapui.impl.rest.actions.oauth;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.support.components.WebViewBasedBrowserComponent;
import com.eviware.soapui.support.components.WebViewBasedBrowserComponentFactory;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

/**
 * Implementation based on the JavaFX WebView component.
 */
public class WebViewUserBrowserFacade implements UserBrowserFacade {

    private WebViewBasedBrowserComponent browserComponent;
    private JFrame popupWindow;

    public WebViewUserBrowserFacade() {
        this(false);
    }

    public WebViewUserBrowserFacade(boolean addNavigationBar) {
        browserComponent = WebViewBasedBrowserComponentFactory.createBrowserComponent(addNavigationBar);
    }

    @Override
    public void open(URL url) {
        popupWindow = new JFrame("Browser");
        popupWindow.setIconImages(SoapUI.getFrameIcons());
        popupWindow.getContentPane().add(browserComponent.getComponent());
        popupWindow.setBounds(100, 100, 800, 600);
        popupWindow.setVisible(true);
        popupWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                browserComponent.close(true);
            }
        });
        browserComponent.navigate(url.toString());
    }

    @Override
    public void addBrowserListener(BrowserListener listener) {
        browserComponent.addBrowserStateListener(listener);
    }

    @Override
    public void removeBrowserStateListener(BrowserListener listener) {
        browserComponent.removeBrowserStateListener(listener);
    }

    @Override
    public void close() {

        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    popupWindow.setVisible(false);
                    popupWindow.dispose();
                }
            });
            browserComponent.close(true);
        } catch (Exception e) {
            SoapUI.log.debug("Could not close window due to unexpected error: " + e.getMessage() + "!");
        }

    }

    @Override
    public void executeJavaScript(String script) {
        browserComponent.executeJavaScript(script);
    }

}
