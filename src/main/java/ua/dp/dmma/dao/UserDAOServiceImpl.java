package ua.dp.dmma.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ua.dp.dmma.model.User;

import java.util.List;

/**
 * @author Dmytro_Mazan
 */
public class UserDAOServiceImpl extends AbstractDAOService<User> implements UserDAOService {
    @Override
    public User getById(Long id) {
        return get(id);
    }

    @Override
    public User getByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        List<User> list = criteria.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void add(User user) {
        save(user);
    }
}
