package ua.dp.dmma.dao;

import ua.dp.dmma.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dmytro Mazan
 */
public class MessageDAOServiceMemoryImpl implements MessageDAOService {
    private AtomicLong atomicInteger = new AtomicLong();
    private Map<Long, Message> messageMap = new ConcurrentHashMap<Long, Message>();

    @Override
    public void add(Message message) {
        message.setId(atomicInteger.getAndIncrement());
        messageMap.put(message.getId(), message);
    }

    @Override
    public Message getById(Long id) {
        return messageMap.get(id);
    }

    @Override
    public void deleteById(Long id) {
        messageMap.remove(id);
    }

    @Override
    public void updateMessage(Message message) {
        messageMap.put(message.getId(), message);
    }

    @Override
    public List<Message> getAll() {
        return new ArrayList<Message>(messageMap.values());
    }

    @Override
    public List<Message> getByUserId(Long userId) {
        List<Message> filteredList = new ArrayList<Message>();
        for (Map.Entry<Long, Message> entry : messageMap.entrySet()) {
            if (userId.equals(entry.getValue().getUser().getId())) {
                filteredList.add(entry.getValue());
            }
        }
        return filteredList;
    }
}
