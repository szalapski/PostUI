

package com.eviware.soapui.impl.wsdl.submit.transports.http.support.metrics;

/**
 * We are using this instead of org.apache.commons.lang.time.Stopwatch because
 * we want nanosecond precision
 */
public interface Stopwatch {

    long getStart();

    long getStop();

    void start();

    void stop();

    long getDuration();

    void reset();

    void add(long value);

    boolean isStarted();

    boolean isStopped();

    void set(long start, long end);

}
