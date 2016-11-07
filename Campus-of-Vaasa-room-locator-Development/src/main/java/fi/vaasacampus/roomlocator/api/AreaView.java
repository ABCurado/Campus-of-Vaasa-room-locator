package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Area;
import fi.vaasacampus.roomlocator.core.Building;
import fi.vaasacampus.roomlocator.core.Floor;
import fi.vaasacampus.roomlocator.core.Room;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by niko on 10.10.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaView {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private OrganizationView organization;

    @JsonProperty
    private Set<CoordinateView> coordinates;

    public AreaView(Long id, String name, OrganizationView organization, Set<CoordinateView> coordinates) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.coordinates = coordinates;
    }

    public static AreaView summaryOf (Area a) {
        if (a instanceof Room) {
            return RoomView.summaryOf((Room) a);
        } else if (a instanceof Floor) {
            return FloorView.summaryOf((Floor) a);
        } else if (a instanceof Building) {
            return BuildingView.summaryOf((Building) a);
        }
        return new AreaView(
                a.getId(),
                a.getName(),
                OrganizationView.detailsOf(a.getOrganization()),
                a.getCoordinates().stream().map(CoordinateView::summaryOf).collect(Collectors.toSet())
        );
    }
}
