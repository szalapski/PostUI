

package com.eviware.soapui.support.dnd;

public interface ModelItemDropHandler<T> {
    public boolean canDrop(T source, T target, int dropAction, int dropType);

    public boolean drop(T source, T target, int dropAction, int dropType);

    public String getDropInfo(T sourceModelItem, T targetModelItem, int dropAction, int dropType);
}
