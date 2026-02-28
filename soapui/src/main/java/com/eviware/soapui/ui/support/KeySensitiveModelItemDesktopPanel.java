

package com.eviware.soapui.ui.support;

import com.eviware.soapui.model.ModelItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Adds KeyListener to panels and handles it.
 *
 * @param <T>
 * @author robert.nemet
 */
@SuppressWarnings("serial")
public abstract class KeySensitiveModelItemDesktopPanel<T extends ModelItem> extends ModelItemDesktopPanel<T> implements
        KeyListener {
    public KeySensitiveModelItemDesktopPanel(T modelItem) {
        super(modelItem);

        this.addKeyListener(this);
    }

    @Override
    protected boolean release() {
        removeKeyListener(this);
        return super.release();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F2:
                renameModelItem();
                break;
            case KeyEvent.VK_F9:
                cloneModelItem();
                break;
        }
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    protected void renameModelItem() {
    }

    ;

    protected void cloneModelItem() {
    }

    ;


}
