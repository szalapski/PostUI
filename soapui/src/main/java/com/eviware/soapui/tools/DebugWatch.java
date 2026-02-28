

package com.eviware.soapui.tools;

/**
 * @author joel.jonsson
 */
public class DebugWatch {
    private final String name;
    long start;

    public DebugWatch(String name) {
        System.out.println(String.format("START %s", name));
        this.name = name;
        start = System.nanoTime();
    }

    public void print(String message) {
        System.out.println(String.format("%s %d %s", name, (System.nanoTime() - start) / 1000000, message));
    }
}
