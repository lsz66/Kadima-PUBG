package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.User;
import cn.lsznb.kadima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李尚哲
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

    @PostMapping("/login")
    public String login(HttpSession session, User user) {
        if (service.login(user)) {
            session.setAttribute("user", service.getUser(user.getUsername()));
            return "1";
        } else {
            return "0";
        }
    }

    @GetMapping
    public List<User> getAllUser() {
        return service.showAllUser();
    }

    @DeleteMapping
    public void del(Integer id) {
        service.delete(id);
    }

    @PutMapping("active")
    public void active(Integer id) {
        service.active(id);
    }

    @PutMapping("update")
    public void update(User user) {
        System.out.println(user);
        service.update(user);
    }

    @PostMapping
    public String register(String username, String password, String confirmPassword) {
        if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
            return "3";
        }
        if (password.equals(confirmPassword)) {
            User user = new User(username, password, 1);
            if (service.register(user)) {
                return "1";
            } else {
                return "2";
            }
        } else {
            return "0";
        }
    }
}
