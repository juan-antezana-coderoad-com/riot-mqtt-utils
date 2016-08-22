package com.tierconnect.riot;

import com.google.common.base.Optional;
import com.tierconnect.riot.utils.YamUtils;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * MqttHelperParser class.
 *
 * @author jantezana
 * @version 8/19/16
 */
public class MqttHelperParser {
    private static final Logger logger = Logger.getLogger(MqttHelperParser.class);

    private Options options;
    private CommandLine line;
    private String configPath;

    /**
     * Default constructor of MqttHelperParser.
     */
    public MqttHelperParser() {
        this.options = new Options();
        initializeOptions();
    }

    /**
     * Initialize the options.
     */
    public void initializeOptions() {
        options.addOption("conf", true, "the path of the yam file");
        options.addOption("help", false, "show this help");
    }

    /**
     * Parses the options.
     *
     * @param args the arguments
     */
    public void parseOptions(final String[] args) {
        CommandLineParser parser = new BasicParser();

        try {
            line = parser.parse(options, args);
        } catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(
                String.format("java -cp xxxx %s", MqttHelper.class.getCanonicalName()), options);
            System.exit(1);
        }

        if (line.hasOption("conf")) {
            configPath = line.getOptionValue("conf");
        }

        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -cp xxxx YYYY", options);
            System.exit(1);
        }
    }

    /**
     * Parses a ReplayConfiguration from a yml file.
     */
    public Optional<RiotConfiguration> parserConfiguration()
    throws MqttHelperException {
        RiotConfiguration result;
        if (configPath != null) {
            File configFile = new File(configPath);
            if (configFile.exists() && configFile.isFile()) {
                try {
                    result = YamUtils.readYmlFile(configFile, RiotConfiguration.class).get();
                } catch (IOException ioException) {
                    throw new MqttHelperException("Mistake to read the configuration file.",
                                                  ioException);
                }
            } else {
                throw new MqttHelperException(String.format(
                    "Invalid file, please verify if the path: %s for the configuration is correct.",
                    configPath));
            }
        } else {
            throw new MqttHelperException(
                "Mistakes to read the configuration path. please enter a path.. using the argument -conf");
        }

        return Optional.fromNullable(result);
    }

}
