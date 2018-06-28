package com.kadima.pubg.service;

import com.kadima.pubg.dao.UserDAO;
import com.kadima.pubg.dto.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO dao = new UserDAO();

    private int toInt(String num) {
        return Integer.parseInt(num);
    }

    public boolean login(String username, String password, String root) {
        try {
            return dao.query(username, password, toInt(root));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean register(String username, String password, String root) {
        try {
            return dao.add(username, password, Integer.parseInt(root));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String id, String username, String password, String root) {
        try {
            dao.update(toInt(id), username, password, toInt(root));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        try {
            dao.delete(toInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void active(String id) {
        try {
            dao.active(toInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> showAllUser() {
        try {
            return dao.queryAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(String username) {
        try {
            return dao.getDTO(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
