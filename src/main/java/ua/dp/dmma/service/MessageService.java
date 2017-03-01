package ua.dp.dmma.service;

import ua.dp.dmma.model.Message;

import java.util.List;

/**
 * @author Dmytro_Mazan
 */
public interface MessageService
{
    Message findMessageById(Long messageId);

    void updateMessage(Message message);

    List<Message> findAllMessages();

    List<Message> findAllMessagesByUser(Long userId);

    void deleteMessage(Long id);

    void createMessage(Message message);
}
