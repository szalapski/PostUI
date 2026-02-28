

package com.eviware.soapui.impl.wsdl.teststeps.assertions.recent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class BoundedQueue {
    private final int MAX_SIZE = 5;

    private LinkedList<String> queue;

    public BoundedQueue() {
        this.queue = new LinkedList<>();
    }

    public void remove(String e) {
        this.queue.remove(e);
    }

    public void add(String e) {
        if (this.queue.contains(e)) {
            return;
        }

        this.queue.addLast(e);

        if (this.queue.size() > MAX_SIZE) {
            this.queue.removeFirst();
        }
    }

    public List<String> getByAlphabeticalOrder() {
        List<String> list = new ArrayList<>(this.queue);
        Collections.sort(list);
        return list;
    }

    public List<String> getByInsertionOrder() {
        return new LinkedList<>(this.queue);
    }
}
