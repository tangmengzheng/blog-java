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
    int createPost(Post post);

    List<Post> getArticles(@Param(value="userId") Long userId);

    int deletePost(Long id);

    Long getUserIdByPostId(Long postId);

    Post getPostById(Long id);


    List<Post> getPostByPid(Long pid);
}
