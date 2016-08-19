package com.tierconnect.riot;

/**
 * Created by Juan Antezana Adrian on 8/19/2016.
 */
public class MqttHelperException extends Exception {

    public MqttHelperException(String message) {
        super(message);
    }

    public MqttHelperException(String message, Throwable cause) {
        super(message, cause);
    }
}
