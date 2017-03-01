package ua.dp.dmma.service;

import ua.dp.dmma.model.User;

/**
 * @author Dmytro_Mazan
 */
public interface UserService
{
    User findUserById(Long userId);

    User findUserByName(String name);

    void createUser(User user);
}
