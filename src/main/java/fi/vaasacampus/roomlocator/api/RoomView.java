package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Room;

/**
 * Created by niko on 1.11.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomView extends AreaView{
    @JsonProperty
    private FloorView floor;

    @JsonProperty
    private String photo;

    public RoomView(Long id, String name, OrganizationView organization, FloorView floor, String photo) {
        super(id, name, organization);
        this.floor = floor;
        this.photo = photo;
    }

    public static RoomView summaryOf(Room r) {
        return new RoomView(
                r.getId(),
                r.getName(),
                OrganizationView.detailsOf(r.getOrganization()),
                null,
                r.getPhoto()
        );
    }

    public static RoomView detailsOf(Room r) {
        RoomView rw = summaryOf(r);
        rw.setFloor(FloorView.summaryOf(r.getFloor()));
        return rw;
    }

    public FloorView getFloor() {
        return floor;
    }

    public void setFloor(FloorView floor) {
        this.floor = floor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
