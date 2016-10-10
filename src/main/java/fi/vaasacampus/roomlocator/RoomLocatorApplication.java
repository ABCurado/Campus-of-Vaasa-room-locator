package fi.vaasacampus.roomlocator;

import fi.vaasacampus.roomlocator.health.TemplateHealthCheck;
import fi.vaasacampus.roomlocator.resources.AreaResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by niko on 4.10.2016.
 */
public class RoomLocatorApplication extends Application<RoomLocatorConfiguration> {
    public static void main(String[] args) throws Exception {
        new RoomLocatorApplication().run(args);
    }

    public void run(RoomLocatorConfiguration configuration, Environment env) throws Exception {
        final AreaResource areaResource = new AreaResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        env.healthChecks().register("template", healthCheck);
        env.jersey().register(areaResource);
    }
}
