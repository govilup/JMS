package org.jmsdemo;

/**
 * Demo application to publish and receive JMS message
 *
 * @author Govil Kumar
 */
public class App 
{
    public static void main( String[] args )
    {
        JMSProducer.sendMessage("Hello World");
        JMSReceiver.receiveMessage();
    }
}
