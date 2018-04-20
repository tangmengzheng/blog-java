package blog.service;

import blog.dao.PostDao;
import blog.model.Message;
import blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private MessageService messageService;

    @Autowired
    private PostService postService;

    public boolean postComment(Post post) {
        //生成消息
        Message message = this.generateMessage(post);
        messageService.createMessage(message);
        return (postDao.createPost(post)==1);
    }

    public boolean deleteComment(Long id) {
        return (postDao.deletePost(id) == 1);
    }

    public Post getCommentById(Long id) {
        return postDao.getPostById(id);
    }

    /**
     * 根据发表的内容生成消息
     * @param post
     * @return
     */
    private Message generateMessage(Post post) {
        Message message = new Message();

        message.setPostId(post.getId());
        message.setCommenterId(post.getUserId());
        Long reminderId = postService.getUserIdByPostId(post.getPid());
        message.setReminderId(reminderId);
        message.setMessage("You have a message !");
        return message;
    }
}
