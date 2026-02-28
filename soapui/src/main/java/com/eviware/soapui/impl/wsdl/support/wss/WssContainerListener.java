

package com.eviware.soapui.impl.wsdl.support.wss;

// FIXME Consider break this interface in sub interfaces as many implementing classes only use cryptoUpdated 
public interface WssContainerListener {
    public void outgoingWssEntryAdded(WssEntry entry);

    public void outgoingWssEntryRemoved(WssEntry entry);

    public void outgoingWssEntryMoved(WssEntry entry, int offset);

    public void cryptoAdded(WssCrypto crypto);

    public void cryptoRemoved(WssCrypto crypto);

    public void cryptoUpdated(WssCrypto crypto);

    public void incomingWssAdded(IncomingWss incomingWss);

    public void incomingWssRemoved(IncomingWss incomingWss);

    public void outgoingWssAdded(OutgoingWss outgoingWss);

    public void outgoingWssRemoved(OutgoingWss outgoingWss);

}
