package fi.vaasacampus.roomlocator.db;

import fi.vaasacampus.roomlocator.core.Room;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Optional;

/**
 * Created by niko on 1.11.2016.
 */
public class RoomDAO extends AbstractDAO<Room>{
    public RoomDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Room> findById(Long id) {
        return Optional.ofNullable((Room) criteria().add(Restrictions.eq("id", id)).uniqueResult());
    }
}
