

package com.eviware.soapui.support.dnd;

import com.eviware.soapui.model.ModelItem;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class ModelItemTransferable implements Transferable {
    public static final DataFlavor MODELITEM_DATAFLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType,
            "SoapUIModelItem");

    private ModelItem modelItem;

    private DataFlavor[] _flavors = {MODELITEM_DATAFLAVOR};

    /**
     * Constructs a transferrable tree path object for the specified path.
     */
    public ModelItemTransferable(ModelItem path) {
        modelItem = path;
    }

    // Transferable interface methods...
    public DataFlavor[] getTransferDataFlavors() {
        return _flavors;
    }

    public ModelItem getModelItem() {
        return modelItem;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return java.util.Arrays.asList(_flavors).contains(flavor);
    }

    public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.isMimeTypeEqual(MODELITEM_DATAFLAVOR.getMimeType())) // DataFlavor.javaJVMLocalObjectMimeType))
        {
            return modelItem;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
