package blog.dao;

import blog.model.Message;

import java.util.List;

/**
 * Created by tangmengzheng on 2017/1/11.
 */
public interface MessageDao {
    public int createMessage(Message message);

    public int readMessage(Long id);

    public List<Message> getNoReadedMessage(Long userId);
}
