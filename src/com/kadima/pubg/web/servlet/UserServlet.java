package com.kadima.pubg.web.servlet;

import com.google.gson.Gson;
import com.kadima.pubg.dto.User;
import com.kadima.pubg.service.UserService;
import com.kadima.pubg.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    private UserService service = new UserService();

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath() + "/");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (service.login(username, password, "1")) {
            response.getWriter().write("1");
            User user = service.getUser(username);
            request.getSession().setAttribute("user", user);
        } else
            response.getWriter().write("0");
    }

    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonUtil.toJson(service.showAllUser()));
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        service.delete(id);
    }

    public void active(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        service.active(id);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        service.update(id, username, password, "1");
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
            response.getWriter().write("3");
            return;
        }
        if (password.equals(confirmPassword)) {
            if (service.register(username, password, "1"))
                response.getWriter().write("1");
            else
                response.getWriter().write("2");
        } else response.getWriter().write("0");
    }
}
