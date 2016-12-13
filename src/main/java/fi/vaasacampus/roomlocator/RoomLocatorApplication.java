package fi.vaasacampus.roomlocator;

import fi.vaasacampus.roomlocator.core.*;
import fi.vaasacampus.roomlocator.db.BuildingDAO;
import fi.vaasacampus.roomlocator.db.FloorDAO;
import fi.vaasacampus.roomlocator.db.RoomDAO;
import fi.vaasacampus.roomlocator.resources.BuildingResource;
import fi.vaasacampus.roomlocator.resources.FloorResource;
import fi.vaasacampus.roomlocator.resources.RoomResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by niko on 4.10.2016.
 */
public class RoomLocatorApplication extends Application<RoomLocatorConfiguration> {
    public static void main(String[] args) throws Exception {
        new RoomLocatorApplication().run(args);
    }

    private final HibernateBundle<RoomLocatorConfiguration> hibernate = new HibernateBundle<RoomLocatorConfiguration>(Area.class, Room.class, Building.class, Floor.class, Organization.class, Coordinate.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(RoomLocatorConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<RoomLocatorConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new AssetsBundle("/static/", "/", "index.html"));
        bootstrap.addBundle(new SwaggerBundle<RoomLocatorConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RoomLocatorConfiguration roomLocatorConfiguration) {
                return roomLocatorConfiguration.swaggerBundleConfiguration;
            }
        });
    }


    public void run(RoomLocatorConfiguration configuration, Environment env) throws Exception {
        env.jersey().register(
                new RoomResource(
                        new RoomDAO(hibernate.getSessionFactory()
                        )
                )
        );

        env.jersey().register(
                new FloorResource(
                        new FloorDAO(hibernate.getSessionFactory())
                )
        );

        env.jersey().register(
                new BuildingResource(
                        new BuildingDAO(hibernate.getSessionFactory())
                )
        );
    }
}
