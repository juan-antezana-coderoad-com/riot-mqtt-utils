package com.tierconnect.riot;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Juan Antezana Adrian on 8/19/2016.
 */
public class MqttHelper {
    private final static Logger logger = Logger.getLogger(MqttHelper.class);

    /**
     * Main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        MqttHelperParser parser = new MqttHelperParser();
        parser.parseOptions(args);
        try {

            RiotConfiguration riotConfiguration = parser.parserConfiguration().get();
            String topic = riotConfiguration.getTopic();
            String path = riotConfiguration.getPath();
            MqttClient client = new MqttClient(
                String.format("tcp://%s", riotConfiguration.getHost()));

            File directory = new File(path);
            if (directory.isDirectory()) {
                for (File file : directory.listFiles()) {
                    if (file.isFile()) {
                        String message = readContent(file.getPath());
                        client.publish(topic, message);
                    }
                }
            }
        } catch (MqttHelperException e) {
            logger.error(e.getMessage(), e.getCause());
            System.exit(1);
        } catch (IOException e) {
            logger.error(e.getMessage(), e.getCause());
            System.exit(1);
        } catch (RiotMqttException e) {
            logger.error(e.getMessage(), e.getCause());
            System.exit(1);
        }
        System.exit(1);
    }

    private static String readContent(String filePath)
    throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
}
