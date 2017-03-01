package ua.dp.dmma.dao;

import ua.dp.dmma.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dmytro Mazan
 */
public class UserDAOServiceMemoryImpl implements UserDAOService {
    private AtomicLong atomicInteger = new AtomicLong();
    private Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User getByName(String name) {
        for (Map.Entry<Long, User> entry : userMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        user.setId(atomicInteger.getAndIncrement());
        userMap.put(user.getId(), user);
    }
}
