

package com.eviware.x.dialogs;

public interface XProgressDialog {
    void setVisible(boolean visible);

    void run(Worker worker) throws Exception;

    void setCancelLabel(String label);

    void setDeterminate();
}
