package blog.service;

import blog.dao.PostDao;
import blog.dto.CommonResult;
import blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangmengzheng on 2017/1/16.
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostDao dao;

    public CommonResult deletePost(Long id) {
        if(dao.deletePost(id) != 1) {
            return new CommonResult("删除失败");
        }
        return new CommonResult();
    }

    public CommonResult createPost(Post post) {
        if(dao.createPost(post) != 1) {
            return new CommonResult("发表失败");
        }
        return new CommonResult();
    }

    public CommonResult updatePost(Post post) {
        Long id = post.getId();
        if(id == null || "".equals(id)) {
            return new CommonResult("更新失败!");
        }
        return new CommonResult();
    }

    public Long getUserIdByPostId(Long postId) {
        if(postId == null) {
            return null;
        }
        Long userId = dao.getUserIdByPostId(postId);
        return userId;
    }
}
