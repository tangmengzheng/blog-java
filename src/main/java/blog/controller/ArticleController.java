package blog.controller;

import blog.model.Post;
import blog.service.ArticleService;
import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Controller
@RequestMapping(value="/article")
public class ArticleController {
    @Autowired
    ArticleService service;

    @Autowired
    PostService postService;

    @RequestMapping(value="/writeArticle")
    public String write() {
        return "edit";
    }

    @RequestMapping(value="/postArticle")
    public String postArticle(Post article, HttpSession session) {
        article.setUserId((Long)session.getAttribute("userId"));
        article.setType(0);
        article.setPid(0L);

        postService.createPost(article);
        return "redirect:/index";
    }

    @RequestMapping(value="/getArticle/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        List<Post> postList = service.getArticleById(id);
        Post article = null;
        for(Post post : postList) {
            if(post.getId().equals(id)) {
                //将blog与评论分开
                article = post;
                postList.remove(post);
                break;
            }
        }
        model.addAttribute("parent", article);
        model.addAttribute("children", postList);
        return "article";
    }

}
