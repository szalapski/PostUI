

package com.eviware.x.dialogs;

public interface Worker {
    /**
     * Compute the value to be returned by the <code>get</code> method.
     */
    public Object construct(XProgressMonitor monitor);

    public void finished();

    public boolean onCancel();

    public abstract class WorkerAdapter implements Worker {
        public void finished() {
        }

        public boolean onCancel() {
            return false;
        }
    }
}
