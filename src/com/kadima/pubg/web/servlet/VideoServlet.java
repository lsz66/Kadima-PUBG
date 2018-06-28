package com.kadima.pubg.web.servlet;

import com.kadima.pubg.dto.User;
import com.kadima.pubg.service.VideoService;
import com.kadima.pubg.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VideoServlet", urlPatterns = "/video")
public class VideoServlet extends BaseServlet {

    private VideoService service = new VideoService();

    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonUtil.toJson(service.getAllAvailableVideo()));
    }

    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        service.delete(id);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String path = request.getParameter("path");
        User user = (User) request.getSession().getAttribute("user");
        service.add(user.getId(), name, "2", path);
        response.getWriter().write("<script>opener.location.href = opener.location.href;close();layer.msg('视频添加成功')</script>");
    }
}
