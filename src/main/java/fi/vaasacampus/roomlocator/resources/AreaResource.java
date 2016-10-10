package fi.vaasacampus.roomlocator.resources;


import com.codahale.metrics.annotation.Timed;
import fi.vaasacampus.roomlocator.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

/**
 * Created by niko on 4.10.2016.
 */
@Path("/area")
@Produces(MediaType.APPLICATION_JSON)
public class AreaResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public AreaResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
