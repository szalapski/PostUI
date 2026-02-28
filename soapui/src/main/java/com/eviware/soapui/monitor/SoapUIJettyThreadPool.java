

package com.eviware.soapui.monitor;

import com.eviware.soapui.SoapUI;
import org.mortbay.thread.ThreadPool;

import java.util.concurrent.TimeUnit;

public final class SoapUIJettyThreadPool implements ThreadPool {
    @Override
    public boolean dispatch(Runnable arg0) {
        SoapUI.getThreadPool().execute(arg0);
        return true;
    }

    @Override
    public int getIdleThreads() {
        return 0;
    }

    @Override
    public int getThreads() {
        return SoapUI.getThreadPool().getActiveCount();
    }

    @Override
    public boolean isLowOnThreads() {
        return false;
    }

    @Override
    public void join() throws InterruptedException {
        SoapUI.getThreadPool().awaitTermination(30, TimeUnit.SECONDS);
    }
}
