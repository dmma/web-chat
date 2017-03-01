package ua.dp.dmma.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.dp.dmma.model.Message;

import java.util.List;

/**
 * @author Dmytro_Mazan
 */
public class MessageDAOServiceImpl extends AbstractDAOService<Message> implements MessageDAOService {

    @Override
    public void add(Message message) {
        save(message);
    }

    @Override
    public Message getById(Long id) {
        return get(id);
    }

    @Override
    public void deleteById(Long id) {
        Message message = get(id);
        if (message != null) {
            delete(message);
        }
    }

    @Override
    public void updateMessage(Message message) {
        update(message);
    }

    @Override
    public List<Message> getAll() {
        Criteria searchCriteria = getSession().createCriteria(Message.class, "message");
        searchCriteria.createAlias("message.user", "user");
        searchCriteria.addOrder(Order.asc("user.id"));
        return searchCriteria.list();
    }

    @Override
    public List<Message> getByUserId(Long userId) {
        Criteria searchCriteria = getSession().createCriteria(Message.class, "message");
        searchCriteria.createAlias("message.user", "user");
        searchCriteria.add(Restrictions.eq("user.id", userId));
        return searchCriteria.list();
    }
}
