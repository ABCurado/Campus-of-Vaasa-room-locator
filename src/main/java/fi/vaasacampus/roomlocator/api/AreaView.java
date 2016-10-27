package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Area;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by niko on 10.10.2016.
 */
public class AreaView {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private OrganizationView organization;

    @JsonProperty
    private Set<AreaView> areas;

    @JsonProperty
    private String photo;

    @JsonProperty
    private String baseImage;

    @JsonProperty
    private AreaTypeView areaType;

    public AreaView(Long id, String name, OrganizationView organization, Set<AreaView> areas, String photo, String baseImage, AreaTypeView areaType) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.areas = areas;
        this.photo = photo;
        this.baseImage = baseImage;
        this.areaType = areaType;
    }

    public static AreaView summaryOf (Area a) {
        return new AreaView(
                a.getId(),
                a.getName(),
                null,
                a.getAreas().stream().map(AreaView::summaryOf).collect(Collectors.toSet()),
                a.getPhoto(),
                a.getBaseImage(),
                AreaTypeView.detailsOf(a.getAreaType())
        );
    }
}
