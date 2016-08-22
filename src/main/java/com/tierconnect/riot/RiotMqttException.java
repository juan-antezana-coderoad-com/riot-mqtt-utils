package com.tierconnect.riot;

/**
 * RiotMqttException class.
 *
 * @author jantezana
 * @version 8/19/16
 */
public class RiotMqttException extends Exception {

    /**
     * Creates an instance of RiotMqttException
     *
     * @param message the message
     */
    public RiotMqttException(String message) {
        super(message);
    }

    /**
     * Creates an instance of RiotMqttException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public RiotMqttException(String message, Throwable cause) {
        super(message, cause);
    }
}
