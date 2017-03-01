package ua.dp.dmma.dao;

import ua.dp.dmma.model.User;

/**
 * @author Dmytro Mazan
 */
public interface UserDAOService
{
    User getById(Long id);

    User getByName(String name);

    void add(User user);
}
