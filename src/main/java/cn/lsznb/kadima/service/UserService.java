package cn.lsznb.kadima.service;

import cn.lsznb.kadima.entity.User;

import java.util.List;

public interface UserService {

    boolean login(User user);

    boolean register(User user);

    void update(User user);

    void delete(Integer id);

    void active(Integer id);

    List<User> showAllUser();

    User getUser(String username);
}
