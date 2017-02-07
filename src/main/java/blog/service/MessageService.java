package blog.service;

import blog.dao.MessageDao;
import blog.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangmengzheng on 2017/1/19.
 */
@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageDao dao;

    public boolean createMessage(Message message) {
        return dao.createMessage(message) == 1;
    }

    public List<Message> getNoReadedMessage(Long reminderId) {
        List<Message> messages = dao.getNoReadedMessage(reminderId);
        return messages;
    }


}
