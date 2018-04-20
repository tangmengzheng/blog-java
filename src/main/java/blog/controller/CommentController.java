package blog.controller;

import blog.dto.CommonResult;
import blog.model.Post;
import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tangmengzheng on 2016/12/19.
 */
@Controller
@RequestMapping(value="/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value="/makeComment")
    public CommonResult postComment( Post post, HttpSession session) {
        if(post.getPid() == null) {
            return new CommonResult("操作错误");
        }
        Long userId = (Long)session.getAttribute("userId");

        post.setUserId(userId);
        post.setType(1);
        if(!commentService.postComment(post)) {
            return new CommonResult("发表评论失败");
        }

        return new CommonResult();
    }

    @RequestMapping(value="/deleteComment")
    @ResponseBody
    public CommonResult deleteComment(Long id) {
        if(!commentService.deleteComment(id)) {
            return new CommonResult("删除评论失败");
        }
        return new CommonResult();
    }

    @RequestMapping(value = "/getComment/{id}")
    public  String getComment(@PathVariable("id") Long id, Model model) {
        Post comment = commentService.getCommentById(id);

        model.addAttribute("parent", comment);
        //model.addAttribute("children", postList);
        return "article";
    }

}
