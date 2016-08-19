package com.tierconnect.riot;

/**
 * Created by Juan Antezana Adrian on 8/19/2016.
 */
public class RiotConfiguration {
    /**
     * The topic.
     */
    private String topic;

    /**
     * The path where read the files.
     */
    private String path;

    /**
     * The host.
     */
    private String host;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
