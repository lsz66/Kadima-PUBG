package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.Message;
import cn.lsznb.kadima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg/")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping("add")
    public String add(String name, String email, String title, String content) {
        if (name.length() == 0 || email.length() == 0 || title.length() == 0 || content.length() == 0) {
            return "0";
        } else {
            service.add(name, email, title, content);
            return "1";
        }
    }

    @PostMapping("get")
    public List<Message> get() {
        return service.getAllMessage();
    }

    @PostMapping("del")
    public void del(Integer id) {
        service.delete(id);
    }
}
