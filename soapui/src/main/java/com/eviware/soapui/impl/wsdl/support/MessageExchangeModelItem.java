

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.model.tree.nodes.support.EmptyModelItem;

public class MessageExchangeModelItem extends EmptyModelItem {
    public final static String MESSAGE_EXCHANGE = "messageExchange";
    private MessageExchange messageExchange;

    public MessageExchangeModelItem(String title, MessageExchange messageExchange) {
        super(title, null);
        this.messageExchange = messageExchange;
    }

    public MessageExchange getMessageExchange() {
        return messageExchange;
    }

    public void setMessageExchange(MessageExchange messageExchange) {
        MessageExchange oldExchange = this.messageExchange;
        this.messageExchange = messageExchange;

        notifyPropertyChanged(MESSAGE_EXCHANGE, oldExchange, messageExchange);
    }

    public boolean hasRawData() {
        return messageExchange == null ? false : messageExchange.hasRawData();
    }

    @Override
    public ModelItem getParent() {
        return messageExchange == null ? null : messageExchange.getModelItem();
    }

}
