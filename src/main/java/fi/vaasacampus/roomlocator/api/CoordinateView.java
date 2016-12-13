package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Coordinate;

import java.util.Set;

/**
 * Created by niko on 1.11.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateView {
    @JsonProperty
    private Long id;

    @JsonProperty
    private Double latitude;

    @JsonProperty
    private Double longitude;

    @JsonProperty
    private AreaView area;

    public CoordinateView() {}

    public CoordinateView(Long id, Double latitude, Double longitude, AreaView area) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
    }

    public static CoordinateView summaryOf(Coordinate c) {
        return new CoordinateView(
                null,
                c.getLatitude(),
                c.getLongitude(),
                null
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public AreaView getArea() {
        return area;
    }

    public void setArea(AreaView area) {
        this.area = area;
    }
}
