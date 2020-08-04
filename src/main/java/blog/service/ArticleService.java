package blog.service;

import blog.dao.PostDao;
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
public class ArticleService {
    @Autowired
    private PostDao postDao;

    public List<Post> getArticleListByUserId(Long userId) {
        return postDao.getArticles(userId);
    }

    public List<Post> getComments(Long pid) {
        return postDao.getByPid(pid);
    }

    public Post getArticleById(Long id) {
        return postDao.getPostById(id);
    }
}
