

package com.eviware.soapui.impl.wsdl.submit.transports.jms;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.SubmitContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

public class HermesJmsRequestSendReceiveTransport extends HermesJmsRequestTransport {

    public Response execute(SubmitContext submitContext, Request request, long timeStarted) throws Exception {
        Session queueSession = null;
        JMSConnectionHolder jmsConnectionHolder = null;
        try {
            init(submitContext, request);
            jmsConnectionHolder = new JMSConnectionHolder(jmsEndpoint, hermes, false, clientID, username, password);

            // session
            queueSession = jmsConnectionHolder.getSession();

            // queue
            Queue queueSend = jmsConnectionHolder.getQueue(jmsConnectionHolder.getJmsEndpoint().getSend());
            Queue queueReceive = jmsConnectionHolder.getQueue(jmsConnectionHolder.getJmsEndpoint().getReceive());

            Message messageSend = messageSend(submitContext, request, queueSession, jmsConnectionHolder.getHermes(),
                    queueSend, queueReceive);
            MessageConsumer messageConsumer = queueSession.createConsumer(queueReceive,
                    submitContext.expand(messageSelector));

            return makeResponse(submitContext, request, timeStarted, messageSend, messageConsumer);
        } catch (JMSException jmse) {
            return errorResponse(submitContext, request, timeStarted, jmse);
        } catch (Throwable t) {
            SoapUI.logError(t);
        } finally {
            if (jmsConnectionHolder != null) {
                jmsConnectionHolder.closeAll();
            }
            closeSessionAndConnection(jmsConnectionHolder != null ? jmsConnectionHolder.getConnection() : null,
                    queueSession);
        }
        return null;
    }
}
