package com.tierconnect.riot;

import lombok.Data;

/**
 * Created by Juan Antezana Adrian on 8/19/2016.
 */
@Data
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
}
