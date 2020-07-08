package org.jmsdemo;

import javax.jms.*;
import java.net.DatagramSocket;

/**
 *
 * @author Govil Kumar
 */
public class JMSReceiver {

    /**
     * Receive Message.
     *
     * @throws JMSException
     */
    public static void receiveMessage() throws JMSException {
        Connection connection = null;
        try {
            connection = Configuration.getConnection();
            connection.start();
            Session session = Configuration.getSession(connection);
            Destination destination = Configuration.getDestination(session);
            TextMessage textMessage = (TextMessage) getMessageConsumer(session, destination).receive();
            System.out.println(textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * Get the message consumer.
     *
     * @param session
     * @param destination
     * @return MessageConsumer
     * @throws JMSException
     */
    private static MessageConsumer getMessageConsumer(Session session, Destination destination) throws JMSException {
        return session.createConsumer(destination);
    }
}
