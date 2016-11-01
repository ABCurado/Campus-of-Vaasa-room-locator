package fi.vaasacampus.roomlocator.resources;

import fi.vaasacampus.roomlocator.api.FloorView;
import fi.vaasacampus.roomlocator.core.Floor;
import fi.vaasacampus.roomlocator.db.FloorDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by niko on 1.11.2016.
 */
@Path("/floors")
@Api(value = "Floors")
@Produces(MediaType.APPLICATION_JSON)
public class FloorResource {
    private final FloorDAO floorDAO;

    public FloorResource(FloorDAO floorDAO) {
        this.floorDAO = floorDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "Fetch a single floor by id.")
    public FloorView findFloorById(
            @PathParam("id")LongParam id
            ) {
        Floor floor = floorDAO.findById(id.get())
                .orElseThrow(NotFoundException::new);
        return FloorView.detailsOf(floor);
    }
}
