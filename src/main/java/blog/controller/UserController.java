package blog.controller;

import blog.dto.CommonResult;
import blog.model.User;
import blog.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by tangmengzheng on 2016/12/15.
 */
@Controller
public class UserController {
    private static final Logger log =org.apache.log4j.Logger.getLogger(UserController.class);
    @Autowired
    private UserService service;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(User user, HttpSession session, Model model) {
        CommonResult result = service.login(user, session);
        if(!result.isSuccess()) {
            model.addAttribute("errMsg", result.getErrMsg());
            return "login";
        }
        //返回消息
        return "redirect:/index";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        CommonResult result = service.register(user);
        if(!result.isSuccess()) {
            model.addAttribute("errMsg", result.getErrMsg());
            return "register";
        } else {
            model.addAttribute("errMsg", "注册成功，请登录 !");
            return "login";
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if(session != null) {
            session.removeAttribute("userId");
            session.removeAttribute("userName");
        }
        return "redirect:/login";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
