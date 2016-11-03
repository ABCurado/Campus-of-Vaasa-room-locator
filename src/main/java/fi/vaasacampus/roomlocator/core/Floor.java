package fi.vaasacampus.roomlocator.core;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by niko on 1.11.2016.
 */
@Entity
@DiscriminatorValue("2")
public class Floor extends Area{
    @ManyToOne
    @JoinColumn(name = "parent_area_id")
    private Building building;

    @OneToMany(mappedBy = "floor")
    private Set<Room> rooms;

    @Column(name = "base_image")
    private String baseImage;

    public Set<Room> getRooms() {
        return rooms;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }
}
