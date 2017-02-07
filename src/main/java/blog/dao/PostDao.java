package blog.dao;

import blog.model.Post;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
public interface PostDao {
    public int createPost(Post post);

    public List<Post> getArticleList(@Param(value="userId") Long userId);

    public int deletePost(Long id);

    public Long getUserIdByPostId(Long postId);

    public List<Post> getCommentById(Long id);

    public List<Post> getArticleById(Long id);
}
