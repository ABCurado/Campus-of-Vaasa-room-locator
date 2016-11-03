package fi.vaasacampus.roomlocator.db;

import fi.vaasacampus.roomlocator.core.Floor;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Optional;

/**
 * Created by niko on 1.11.2016.
 */
public class FloorDAO extends AbstractDAO<Floor> {
    public FloorDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Floor> findById(Long id) {
        return Optional.ofNullable((Floor) criteria().add(Restrictions.eq("id", id)).uniqueResult());
    }
}
