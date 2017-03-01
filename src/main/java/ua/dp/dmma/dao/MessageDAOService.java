package ua.dp.dmma.dao;

import ua.dp.dmma.model.Message;

import java.util.List;

/**
 * @author Dmytro Mazan
 */
public interface MessageDAOService
{
    void add(Message message);

    Message getById(Long id);

    void deleteById(Long id);

    void updateMessage(Message message);

    List<Message> getAll();

    List<Message> getByUserId(Long userId);
}
