package fi.vaasacampus.roomlocator.db;

import fi.vaasacampus.roomlocator.api.AreaView;
import fi.vaasacampus.roomlocator.core.Area;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.jersey.params.LongParam;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Created by niko on 10.10.2016.
 */
public class AreaDAO extends AbstractDAO<Area> {
    public AreaDAO(SessionFactory factory) {
        super(factory);
    }

    public Area findById(Long id) {
        return (Area) criteria().add(Restrictions.eq("id", id)).uniqueResult();
    }
}
