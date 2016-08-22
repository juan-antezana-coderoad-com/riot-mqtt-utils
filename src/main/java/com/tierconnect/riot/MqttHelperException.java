package com.tierconnect.riot;

/**
 * MqttHelperException class.
 *
 * @author jantezana
 * @version 8/19/16
 */
public class MqttHelperException extends Exception {

    public MqttHelperException(String message) {
        super(message);
    }

    public MqttHelperException(String message, Throwable cause) {
        super(message, cause);
    }
}
