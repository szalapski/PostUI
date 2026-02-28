

package com.eviware.soapui.security.tools;

import com.eviware.soapui.config.MaliciousAttachmentConfig;

import java.util.ArrayList;
import java.util.List;

public class AttachmentHolder {

    List<MaliciousAttachmentConfig> list;

    public void addElement(MaliciousAttachmentConfig config) {
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(config);
    }

    public void removeElement(int i) {
        if (list != null) {
            list.remove(i);
        }
    }

    public int size() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public void clear() {
        if (list != null) {
            list.clear();
        }
    }

    public List<MaliciousAttachmentConfig> getList() {
        return list;
    }

}
