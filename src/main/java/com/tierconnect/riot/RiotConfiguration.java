package com.tierconnect.riot;

/**
 * RiotConfiguration class.
 *
 * @author jantezana
 * @version 8/19/16
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

    /**
     * Gets the topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets the topic.
     *
     * @param topic the new topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     *
     * @param host the new host
     */
    public void setHost(String host) {
        this.host = host;
    }
}
