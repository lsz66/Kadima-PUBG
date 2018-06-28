package com.kadima.pubg.web.servlet;

import com.kadima.pubg.dto.Article;
import com.kadima.pubg.dto.User;
import com.kadima.pubg.service.ArticleService;
import com.kadima.pubg.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ArticleServlet", urlPatterns = "/article")
public class ArticleServlet extends BaseServlet {

    private ArticleService service = new ArticleService();

    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String category = request.getParameter("type");
        response.getWriter().write(JsonUtil.toJson(service.queryByCategory(category)));
    }

    public void getNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonUtil.toJson(service.getAllNews()));
    }

    public void getStrategy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonUtil.toJson(service.getAllStrategy()));
    }

    public void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Article article = service.get(id);
        request.getSession().setAttribute("article", article);
        request.getRequestDispatcher(request.getContextPath() + "article.jsp").forward(request, response);
    }

    public void mod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Article article = service.get(id);
        request.getSession().setAttribute("article", article);
        request.getRequestDispatcher(request.getContextPath() + "admin/modArticle.jsp").forward(request, response);
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        service.delete(id);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        service.add(user.getId(), title, type, content);
        response.getWriter().write("<script>opener.location.href = opener.location.href;close();layer.msg('添加成功')</script>");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        service.update(id, user.getId(), title, type, content);
        String redirect = Integer.parseInt(type) <= 3 ? "news.html" : "strategy.html";
        response.sendRedirect(request.getContextPath() + "admin/" + redirect);
    }
}
