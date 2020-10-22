package org.ikora.inspector.run;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ikora.inspector.configuration.InspectorConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.ikora.model.Projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Start analysis...");
        Instant start = Instant.now();

        final InspectorConfiguration configuration = readConfiguration(args);
        final Projects projects = Builder.build(configuration);
        final Database database = createDatabase(configuration);

        database.store(projects);

        long end = Duration.between(start, Instant.now()).toMillis();
        logger.info(String.format("Analysis performed in %d ms", end));
    }

    private InspectorConfiguration readConfiguration(String... args) throws ParseException, IOException {
        Options options = new Options();

        options.addOption("config", true, "path to the json configuration file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if(!cmd.hasOption("config")){
            throw new MissingArgumentException("config");
        }

        return InspectorConfiguration.initialize(cmd.getOptionValue("config"));
    }

    private Database createDatabase(InspectorConfiguration configuration) {
        final File output = new File(configuration.getOutput());
        DatabaseSettings.setUrl(output.getAbsolutePath());

        return new Database();
    }
}