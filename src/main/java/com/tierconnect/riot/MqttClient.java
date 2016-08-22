package com.tierconnect.riot;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * MqttClient class.
 *
 * @author jantezana
 * @version 8/19/16
 */
public class MqttClient {

    private static final Logger logger = Logger.getLogger(MqttClient.class);

    public MqttAsyncClient client;

    /**
     * Creates an instance of MqttClient
     *
     * @param host the host
     * @throws RiotMqttException
     */
    public MqttClient(final String host)
    throws RiotMqttException {
        Preconditions.checkNotNull(host, "The host is null");
        try {
            this.client = new MqttAsyncClient(host, MqttAsyncClient.generateClientId(),
                                              new MemoryPersistence());
            this.client.connect().waitForCompletion();
        } catch (MqttException e) {
            throw new RiotMqttException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Publish a message in a topic
     *
     * @param topic   the topic
     * @param message the message
     * @throws RiotMqttException
     */
    public void publish(final String topic, final String message)
    throws RiotMqttException {
        Preconditions.checkNotNull(topic, "The topic is null");
        Preconditions.checkNotNull(message, "The message is null");
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(message.getBytes());
        try {
            client.publish(topic, mqttMessage);
            logger.info(String.format("Topic: %s", topic));
            logger.info(String.format("Message: %s", message));
        } catch (MqttException e) {
            throw new RiotMqttException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Subscribe a topic.
     *
     * @param topic the topic
     * @throws RiotMqttException
     */
    public void subscribe(String topic)
    throws RiotMqttException {
        Preconditions.checkNotNull(topic, "The topic is null");
        try {
            client.subscribe(topic, 2);
        } catch (MqttException e) {
            throw new RiotMqttException(e.getMessage(), e.getCause());
        }
    }
}
