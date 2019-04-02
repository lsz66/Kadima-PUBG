package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.Message;
import cn.lsznb.kadima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李尚哲
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public String add(String name, String email, String title, String content) {
        if (name.length() == 0 || email.length() == 0 || title.length() == 0 || content.length() == 0) {
            return "0";
        } else {
            service.add(name, email, title, content);
            return "1";
        }
    }

    @GetMapping
    public List<Message> get() {
        return service.getAllMessage();
    }

    @DeleteMapping
    public void del(Integer id) {
        service.delete(id);
    }
}
