package cn.lsznb.kadima.controller;

import cn.lsznb.kadima.entity.User;
import cn.lsznb.kadima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("logout")
    public String logout(HttpSession session) throws IOException {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @PostMapping("login")
    public String login(HttpSession session, User user) throws IOException {
        System.out.println(user);
        if (service.login(user)) {
            session.setAttribute("user", service.getUser(user.getUsername()));
            return "1";
        } else return "0";
    }

    @PostMapping("get")
    public List<User> getAllUser() {
        return service.showAllUser();
    }

    @PostMapping("del")
    public void del(Integer id) {
        service.delete(id);
    }

    @PostMapping("active")
    public void active(Integer id) {
        service.active(id);
    }

    @PostMapping("update")
    public void update(User user) {
        service.update(user);
    }

    @PostMapping("register")
    public String register(String username, String password, String confirmPassword) {
        if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0)
            return "3";
        if (password.equals(confirmPassword)) {
            User user = new User(username, password, 1);
            if (service.register(user))
                return "1";
            else
                return "2";
        } else return "0";
    }
}
