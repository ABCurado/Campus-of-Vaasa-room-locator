package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Building;
import fi.vaasacampus.roomlocator.core.Coordinate;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by niko on 1.11.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuildingView extends AreaView {
    @JsonProperty
    private Set<FloorView> floors;

    public BuildingView(
            Long id,
            String name,
            OrganizationView organization,
            Set<CoordinateView> coordinates,
            Set<FloorView> floors) {
        super(id, name, organization, coordinates);
        this.floors = floors;
    }

    public static BuildingView summaryOf(Building b) {
        return new BuildingView(
                b.getId(),
                b.getName(),
                OrganizationView.detailsOf(b.getOrganization()),
                b.getCoordinates().stream().map(CoordinateView::summaryOf).collect(Collectors.toSet()),
                null
        );
    }

    public static BuildingView detailsOf(Building b) {
        BuildingView bw = summaryOf(b);
        bw.setFloors(b.getFloors().stream().map(FloorView::detailsOf).collect(Collectors.toSet()));
        return bw;
    }

    public Set<FloorView> getFloors() {
        return floors;
    }

    public void setFloors(Set<FloorView> floors) {
        this.floors = floors;
    }
}
