package fi.vaasacampus.roomlocator.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by niko on 1.11.2016.
 */
@Entity
@DiscriminatorValue("1")
public class Building extends Area{
    @OneToMany(mappedBy = "building")
    private Set<Floor> floors;

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }
}
