package blog.controller;

import blog.dto.CommonResult;
import blog.model.Message;
import blog.model.Post;
import blog.service.ArticleService;
import blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Controller
public class IndexController {
    @Autowired
    private ArticleService service;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        Long userId = (Long)session.getAttribute("userId");
        List<Post> articleList = service.getArticleListByUserId(userId);
        List<Message> messages = messageService.getNoReadedMessage(userId);
        model.addAttribute("messages", messages);
        model.addAttribute("articleList", articleList);
       return "index";
   }

    @RequestMapping(value="/about", method=RequestMethod.GET)
    public String about() {
        return "about";
    }

}
