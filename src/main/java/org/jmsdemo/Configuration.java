package org.jmsdemo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @author Govil Kumar
 */
public class Configuration {

    //DEFAULT_BROKER_URL is localhost
    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String queue = "DEMO_QUEUE";

    /**
     * Get the connection.
     *
     * @return Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        return new ActiveMQConnectionFactory(url).createConnection();
    }

    /**
     * Get the session
     *
     * @param connection
     * @return Session
     * @throws JMSException
     */
    public static Session getSession(Connection connection) throws JMSException {
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    /**
     * Create destination/queue.
     *
     * @param session
     * @return Destination
     * @throws JMSException
     */
    public static Destination getDestination(Session session) throws  JMSException {
        return session.createQueue(queue);
    }

}
