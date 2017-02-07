package blog.dao;

import blog.model.Post;
import blog.model.User;

import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/15.
 */

public interface UserDao {
  public User getUserByName(String name);

  public int changePassword(Long id, String password);

  public int createUser(User user);

  public int editUser(User user);

  public int nameUsedTimes(String name);

  public List<Post> getArticleList(long id);
}
