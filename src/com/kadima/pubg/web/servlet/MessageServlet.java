package com.kadima.pubg.web.servlet;

import com.kadima.pubg.service.MessageService;
import com.kadima.pubg.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/msg")
public class MessageServlet extends BaseServlet {

    private MessageService service = new MessageService();

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (name.length() == 0 || email.length() == 0 || title.length() == 0 || content.length() == 0) {
            response.getWriter().write("0");
        } else {
            service.add(name, email, title, content);
            response.getWriter().write("1");
        }
    }

    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonUtil.toJson(service.getAllMessage()));
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        service.delete(id);
    }
}
