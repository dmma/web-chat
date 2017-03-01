package ua.dp.dmma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.dmma.dao.MessageDAOService;
import ua.dp.dmma.model.Message;

import java.util.List;

/**
 * @author Dmytro_Mazan
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAOService daoService;

    @Override
    public Message findMessageById(Long messageId) {
        return daoService.getById(messageId);
    }

    @Override
    public void updateMessage(Message message) {
        daoService.updateMessage(message);
    }

    @Override
    public List<Message> findAllMessages() {
        return daoService.getAll();
    }

    @Override
    public List<Message> findAllMessagesByUser(Long userId) {
        return daoService.getByUserId(userId);
    }

    @Override
    public void deleteMessage(Long id) {
        daoService.deleteById(id);
    }

    @Override
    public void createMessage(Message message) {
        daoService.add(message);
    }
}
