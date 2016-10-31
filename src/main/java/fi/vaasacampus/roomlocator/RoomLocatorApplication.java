package fi.vaasacampus.roomlocator;

import fi.vaasacampus.roomlocator.core.Area;
import fi.vaasacampus.roomlocator.core.AreaType;
import fi.vaasacampus.roomlocator.core.Organization;
import fi.vaasacampus.roomlocator.db.AreaDAO;
import fi.vaasacampus.roomlocator.health.TemplateHealthCheck;
import fi.vaasacampus.roomlocator.resources.AreaResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by niko on 4.10.2016.
 */
public class RoomLocatorApplication extends Application<RoomLocatorConfiguration> {
    public static void main(String[] args) throws Exception {
        new RoomLocatorApplication().run(args);
    }

    private final HibernateBundle<RoomLocatorConfiguration> hibernate = new HibernateBundle<RoomLocatorConfiguration>(Area.class, Organization.class, AreaType.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(RoomLocatorConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<RoomLocatorConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new AssetsBundle("/static/", "/", "index.html"));
    }


    public void run(RoomLocatorConfiguration configuration, Environment env) throws Exception {
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        env.healthChecks().register("template", healthCheck);

        final AreaDAO areaDAO = new AreaDAO(hibernate.getSessionFactory());
        env.jersey().register(new AreaResource(areaDAO));
    }
}
