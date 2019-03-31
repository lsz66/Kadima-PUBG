package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.Article;
import cn.lsznb.kadima.entity.User;
import cn.lsznb.kadima.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping
    public List<Article> get(Integer type) {
        return service.queryByCategory(type);
    }

    @PostMapping
    public String add(HttpSession session, String title, Integer type, String content) {
        User user = (User) session.getAttribute("user");
        service.add(user.getId(), title, type, content);
        return "<script>opener.location.href = opener.location.href;close();layer.msg('添加成功')</script>";
    }

    @PutMapping
    public ModelAndView update(Integer id, String title, Integer type, String content, HttpSession session) {
        User user = (User) session.getAttribute("user");
        service.update(id, user.getId(), title, type, content);
        String redirect = type <= 3 ? "news.html" : "strategy.html";
        return new ModelAndView(redirect);
    }

    @GetMapping("getNews")
    public List<Article> getNews() {
        return service.getAllNews();
    }

    @PostMapping("getStrategy")
    public List<Article> getStrategy() {
        return service.getAllStrategy();
    }

    @PostMapping("view")
    public ModelAndView view(Integer id) {
        ModelAndView mav = new ModelAndView();
        Article article = service.get(id);
        mav.addObject("article", article);
        mav.setViewName("forward:article.jsp");
        return mav;
    }

    @GetMapping("mod")
    public ModelAndView mod(Integer id) {
        System.out.println(id);
        ModelAndView mav = new ModelAndView();
        Article article = service.get(id);
        mav.addObject("article", article);
        mav.setViewName("forward:admin/modArticle.jsp");
        return mav;
    }
}
