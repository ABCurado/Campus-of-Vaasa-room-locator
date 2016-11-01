package fi.vaasacampus.roomlocator.resources;

import fi.vaasacampus.roomlocator.api.BuildingView;
import fi.vaasacampus.roomlocator.core.Building;
import fi.vaasacampus.roomlocator.db.BuildingDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by niko on 1.11.2016.
 */
@Path("/buildings")
@Api(value = "Buildings")
@Produces(MediaType.APPLICATION_JSON)
public class BuildingResource {
    private final BuildingDAO buildingDAO;

    public BuildingResource(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "Fetch a single building by id")
    public BuildingView findBuildingById(
            @PathParam("id") LongParam id
    ) {
        Building building = buildingDAO.findById(id.get())
                .orElseThrow(NotFoundException::new);
        return BuildingView.detailsOf(building);
    }
}
