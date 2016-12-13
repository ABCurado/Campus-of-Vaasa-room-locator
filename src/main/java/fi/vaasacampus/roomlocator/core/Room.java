package fi.vaasacampus.roomlocator.core;

import javax.persistence.*;

/**
 * Created by niko on 1.11.2016.
 */
@Entity
@DiscriminatorValue("3")
public class Room extends Area{
    @ManyToOne
    @JoinColumn(name = "parent_area_id")
    private Floor floor;

    @Column(name = "photo")
    private String photo;

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
