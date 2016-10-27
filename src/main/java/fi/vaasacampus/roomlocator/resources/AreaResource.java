package fi.vaasacampus.roomlocator.resources;


import fi.vaasacampus.roomlocator.api.AreaView;
import fi.vaasacampus.roomlocator.db.AreaDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by niko on 4.10.2016.
 */
@Path("/area")
@Produces(MediaType.APPLICATION_JSON)
public class AreaResource {
    private final AreaDAO areaDAO;

    public AreaResource(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public AreaView findAreaById(
            @PathParam("id") LongParam id
            ) {
        return AreaView.summaryOf(areaDAO.findById(id.get()));
    }
}
