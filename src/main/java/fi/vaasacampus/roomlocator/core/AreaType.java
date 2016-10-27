package fi.vaasacampus.roomlocator.core;

import javax.persistence.*;

/**
 * Created by niko on 10.10.2016.
 */
@Entity
@Table(name = "area_type")
public class AreaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
