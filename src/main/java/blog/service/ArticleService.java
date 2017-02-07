package blog.service;

import blog.dao.PostDao;
import blog.dto.CommonResult;
import blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Service
@Transactional
public class ArticleService {
    @Autowired
    private PostDao dao;

    public List<Post> getArticleListByUserId(Long userId) {
        return dao.getArticleList(userId);
    }

    public List<Post> getArticleById(Long id) {
        return dao.getArticleById(id);
    }
}
