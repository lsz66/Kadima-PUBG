package cn.lsznb.kadima.service.impl;

import cn.lsznb.kadima.entity.User;
import cn.lsznb.kadima.mapper.UserMapper;
import cn.lsznb.kadima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public boolean login(User user) {
        return mapper.query(user);
    }

    @Override
    public boolean register(User user) {
        return mapper.add(user);
    }

    @Override
    public void update(User user) {
        mapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void active(Integer id) {
        mapper.active(id);
    }

    @Override
    public List<User> showAllUser() {
        return mapper.queryAll();
    }

    @Override
    public User getUser(String username) {
        return mapper.getDTO(username);
    }
}
