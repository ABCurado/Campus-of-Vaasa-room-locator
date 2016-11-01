package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Floor;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by niko on 1.11.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FloorView extends AreaView {
    @JsonProperty
    private  BuildingView building;

    @JsonProperty
    private Set<RoomView> rooms;

    @JsonProperty
    private String baseImage;

    public FloorView(
            Long id,
            String name,
            OrganizationView organization,
            BuildingView building,
            Set<RoomView> rooms,
            String baseImage) {
        super(id, name, organization);
        this.building = building;
        this.rooms = rooms;
        this.baseImage = baseImage;
    }

    public static FloorView summaryOf(Floor f) {
        return new FloorView(
                f.getId(),
                f.getName(),
                OrganizationView.detailsOf(f.getOrganization()),
                BuildingView.summaryOf(f.getBuilding()),
                null,
                f.getBaseImage()
        );
    }

    public static FloorView detailsOf(Floor f) {
        FloorView fw = summaryOf(f);
        fw.setRooms(f.getRooms().stream().map(RoomView::summaryOf).collect(Collectors.toSet()));
        return fw;
    }

    public Set<RoomView> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomView> rooms) {
        this.rooms = rooms;
    }

    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    public BuildingView getBuilding() {
        return building;
    }

    public void setBuilding(BuildingView building) {
        this.building = building;
    }
}
