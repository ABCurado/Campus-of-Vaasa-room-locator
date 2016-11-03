package fi.vaasacampus.roomlocator.db;

import fi.vaasacampus.roomlocator.core.Building;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Optional;

/**
 * Created by niko on 1.11.2016.
 */
public class BuildingDAO extends AbstractDAO<Building> {

    public BuildingDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Building> findById(Long id) {
        return Optional.ofNullable((Building) criteria().add(Restrictions.eq("id", id)).uniqueResult());
    }
}
