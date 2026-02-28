

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.support.components.RequestMessageXmlEditor;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.support.editor.xml.support.DefaultXmlDocument;

import java.beans.PropertyChangeEvent;

public class MessageExchangeRequestMessageEditor extends
        RequestMessageXmlEditor<MessageExchangeModelItem, DefaultXmlDocument> {
    private final MessageExchangeModelItem messageExchangeModelItem;

    public MessageExchangeRequestMessageEditor(MessageExchange messageExchange) {
        this(new MessageExchangeModelItem("message exchange request", messageExchange));
    }

    public MessageExchangeRequestMessageEditor(MessageExchangeModelItem messageExchangeModelItem) {
        super(new DefaultXmlDocument(), messageExchangeModelItem);
        this.messageExchangeModelItem = messageExchangeModelItem;

        if (messageExchangeModelItem.getMessageExchange() != null) {
            updateXml();
        }

        messageExchangeModelItem.addPropertyChangeListener(MessageExchangeModelItem.MESSAGE_EXCHANGE, this);

        setEditable(false);
    }

    public void updateXml() {
        try {
            MessageExchange messageExchange = messageExchangeModelItem.getMessageExchange();
            DefaultXmlDocument defaultXmlDocument = getDocument();

            if (messageExchange != null && messageExchange.getOperation() != null) {
                defaultXmlDocument.setTypeSystem(messageExchange.getOperation().getInterface().getDefinitionContext()
                        .getInterfaceDefinition().getSchemaTypeSystem());
            }

            defaultXmlDocument.setDocumentContent(new DocumentContent(null, messageExchange == null ? null : messageExchange.getRequestContentAsXml()));
        } catch (Throwable e) {
            SoapUI.logError(e);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == messageExchangeModelItem
                && evt.getPropertyName().equals(MessageExchangeModelItem.MESSAGE_EXCHANGE)) {
            updateXml();
        } else {
            super.propertyChange(evt);
        }
    }

    @Override
    public void release() {
        super.release();

        messageExchangeModelItem.removePropertyChangeListener(MessageExchangeModelItem.MESSAGE_EXCHANGE, this);
    }
}
