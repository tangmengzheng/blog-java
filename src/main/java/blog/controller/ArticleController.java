package blog.controller;

import blog.model.Post;
import blog.service.ArticleService;
import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Controller
@RequestMapping(value="/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    PostService postService;

    @RequestMapping(value="/writeArticle")
    public String write() {
        return "edit";
    }

    @RequestMapping(value="/postArticle")
    public String postArticle(Post article, HttpSession session) {
        article.setUserId((Long)session.getAttribute("userId"));
        article.setPid(0L);

        postService.createPost(article);
        return "redirect:/index";
    }

    @RequestMapping(value="/getArticle/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        Post article = articleService.getArticleById(id);
        List<Post> comments = articleService.getComments(id);
        model.addAttribute("parent", article);
        model.addAttribute("children", comments);
        return  "article";
    }

}
