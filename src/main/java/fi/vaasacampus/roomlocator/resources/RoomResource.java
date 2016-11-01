package fi.vaasacampus.roomlocator.resources;

import fi.vaasacampus.roomlocator.api.RoomView;
import fi.vaasacampus.roomlocator.core.Room;
import fi.vaasacampus.roomlocator.db.RoomDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by niko on 1.11.2016.
 */
@Path("/rooms")
@Api(value = "Rooms")
@Produces(MediaType.APPLICATION_JSON)
public class RoomResource {
    private final RoomDAO roomDAO;

    public RoomResource(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "Fetch a single room by id.")
    public RoomView findRoomById(
            @PathParam("id")LongParam id
            ) {
        Room room = roomDAO.findById(id.get())
                .orElseThrow(NotFoundException::new);
        return RoomView.detailsOf(room);
    }
}
