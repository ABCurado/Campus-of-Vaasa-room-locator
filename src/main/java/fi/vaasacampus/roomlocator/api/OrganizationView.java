package fi.vaasacampus.roomlocator.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.vaasacampus.roomlocator.core.Organization;

/**
 * Created by niko on 10.10.2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationView {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    public OrganizationView(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static OrganizationView detailsOf (Organization o) {
        return new OrganizationView(
                o.getId(),
                o.getName()
        );
    }
}
