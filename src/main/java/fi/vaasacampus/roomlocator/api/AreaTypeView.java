package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.AreaType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by niko on 10.10.2016.
 */
public class AreaTypeView {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    public AreaTypeView(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AreaTypeView detailsOf (AreaType at) {
        return new AreaTypeView(
                at.getId(),
                at.getName()
        );
    }
}
