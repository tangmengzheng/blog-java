package blog.service;

import blog.dao.MessageDao;
import blog.dao.UserDao;
import blog.dto.CommonResult;
import blog.model.Message;
import blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/15.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private MessageDao messageDao;

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    public CommonResult login(User user, HttpSession session) {

        User dbUser = dao.getUserByName(user.getName());
        if(dbUser == null) {
            CommonResult result = new CommonResult("用户不存在!");
            return result;
        }
        if(!passwordCheck(user.getPassword(), dbUser.getPassword())) {
            return new CommonResult("密码错误！");
        }
        session.setAttribute("userId", dbUser.getId());
        session.setAttribute("userName", dbUser.getName());

        return new CommonResult();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public CommonResult register(User user) {
        String name = user.getName();
        if(isNameUsed(name)) {
            return new CommonResult("用户名已被注册！");
        }
        dao.createUser(user);
        return new CommonResult();
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    public CommonResult changePassword(Long id, String password) {
        password = encode(password);
        if (dao.changePassword(id, password) != 1) {
            return new CommonResult("操作失败");
        }
        return new CommonResult();
    }

    /**
     * 密码核对
     * @param input
     * @param pwd
     * @return
     */
    private boolean passwordCheck(String input, String pwd) {
        if (input == null || "".equals(input)) {
            return false;
        }
        return encode(input).equals(pwd);
    }

    /**
     * 数据加密
     * @param input
     * @return
     */
    private String encode(String input) {
        //数据加密时使用的一些额外变量
        String extra = "3r1rg3qe2rqw4er3";
        if (input == null || "".equals(input)) {
            return null;
        }
        String tmp = DigestUtils.md5Hex(input);
        // 第二次加密
        String password = DigestUtils.md5Hex(tmp + extra);

        return password;
    }




    private boolean isNameUsed(String name) {
        return dao.nameUsedTimes(name) > 0;
    }

    public static void main(String [] args) {
        System.out.println(new UserService().encode("123456"));
    }
}
