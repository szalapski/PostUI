

package com.eviware.soapui.impl.wsdl.submit.transports.jms;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.SubmitContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;

public class HermesJmsRequestPublishTransport extends HermesJmsRequestTransport {

    public Response execute(SubmitContext submitContext, Request request, long timeStarted) throws Exception {
        Session topicSession = null;
        JMSConnectionHolder jmsConnectionHolder = null;
        try {
            init(submitContext, request);
            jmsConnectionHolder = new JMSConnectionHolder(jmsEndpoint, hermes, true, clientID, username, password);

            // session
            topicSession = jmsConnectionHolder.getSession();

            // destination
            Topic topicPublish = jmsConnectionHolder.getTopic(jmsConnectionHolder.getJmsEndpoint().getSend());

            Message messagePublish = messagePublish(submitContext, request, topicSession,
                    jmsConnectionHolder.getHermes(), topicPublish, null);

            return makeEmptyResponse(submitContext, request, timeStarted, messagePublish);
        } catch (JMSException jmse) {
            return errorResponse(submitContext, request, timeStarted, jmse);
        } catch (Throwable t) {
            SoapUI.logError(t);
        } finally {
            if (jmsConnectionHolder != null) {
                jmsConnectionHolder.closeAll();
            }

            closeSessionAndConnection(jmsConnectionHolder != null ? jmsConnectionHolder.getConnection() : null,
                    topicSession);
        }
        return null;
    }

}
