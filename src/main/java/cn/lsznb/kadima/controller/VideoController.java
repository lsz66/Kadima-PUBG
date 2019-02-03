package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.User;
import cn.lsznb.kadima.entity.Video;
import cn.lsznb.kadima.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping("/get")
    public List<Video> get() {
        return service.getAllAvailableVideo();
    }

    @PostMapping("/del")
    public void delete(int id) {
        service.delete(id);
    }

    @PostMapping("/add")
    public void add(HttpSession session, String name, String path) {
        User user = (User) session.getAttribute("user");
        service.add(user.getId(), name, 2, path);
    }
}
