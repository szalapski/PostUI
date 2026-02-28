

package com.eviware.soapui.impl.wsdl.support;

import com.eviware.soapui.impl.support.components.ResponseMessageXmlEditor;
import com.eviware.soapui.impl.wsdl.submit.transports.http.DocumentContent;
import com.eviware.soapui.model.iface.MessageExchange;
import com.eviware.soapui.support.editor.xml.support.DefaultXmlDocument;

import java.beans.PropertyChangeEvent;

public class MessageExchangeResponseMessageEditor extends
        ResponseMessageXmlEditor<MessageExchangeModelItem, DefaultXmlDocument> {
    private final MessageExchangeModelItem messageExchangeModelItem;

    public MessageExchangeResponseMessageEditor(MessageExchange messageExchange) {
        this(new MessageExchangeModelItem("message exchange response", messageExchange));
    }

    public MessageExchangeResponseMessageEditor(MessageExchangeModelItem messageExchangeModelItem) {
        super(new DefaultXmlDocument(), messageExchangeModelItem);
        this.messageExchangeModelItem = messageExchangeModelItem;

        if (messageExchangeModelItem.getMessageExchange() != null) {
            updateXml();
        }

        messageExchangeModelItem.addPropertyChangeListener(MessageExchangeModelItem.MESSAGE_EXCHANGE, this);

        setEditable(false);
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

    public void updateXml() {
        try {
            MessageExchange messageExchange = messageExchangeModelItem.getMessageExchange();
            DefaultXmlDocument defaultXmlDocument = getDocument();

            if (messageExchange != null && messageExchange.getOperation() != null) {
                defaultXmlDocument.setTypeSystem(messageExchange.getOperation().getInterface().getDefinitionContext()
                        .getInterfaceDefinition().getSchemaTypeSystem());
            }

            defaultXmlDocument.setDocumentContent(new DocumentContent(null, messageExchange == null ? null : messageExchange.getResponseContentAsXml()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void release() {
        super.release();

        messageExchangeModelItem.removePropertyChangeListener(MessageExchangeModelItem.MESSAGE_EXCHANGE, this);
    }
}
