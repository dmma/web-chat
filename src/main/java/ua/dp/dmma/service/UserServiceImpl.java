package ua.dp.dmma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.dmma.dao.UserDAOService;
import ua.dp.dmma.model.User;

/**
 * @author Dmytro_Mazan
 */
@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAOService daoService;

    @Override
    public User findUserById(Long userId)
    {
        return daoService.getById(userId);
    }

    @Override
    public User findUserByName(String name) {
        return daoService.getByName(name);
    }

    @Override
    public void createUser(User user) {
        daoService.add(user);
    }
}
