package org.jmsdemo;

import javax.jms.*;

/**
 * @author Govil Kumar
 */
public class JMSProducer {

    /**
     * Publish the message to the queue.
     *
     * @param message
     */
    public static void sendMessage(String message) throws JMSException {
        Connection connection = null;
        try {
            connection = Configuration.getConnection();
            connection.start();
            Session session = Configuration.getSession(connection);
            Destination destination = Configuration.getDestination(session);
            messageProducer(session, destination).send(session.createTextMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * Get the Message producer.
     * @param session
     * @param destination
     * @return MessageProducer
     * @throws JMSException
     */
    private static MessageProducer messageProducer(Session session, Destination destination) throws JMSException {
        return session.createProducer(destination);
    }
}
