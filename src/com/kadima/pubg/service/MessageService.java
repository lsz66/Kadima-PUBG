package com.kadima.pubg.service;

import com.kadima.pubg.dao.MessageDAO;
import com.kadima.pubg.dto.Message;

import java.sql.SQLException;
import java.util.List;

public class MessageService {

    private MessageDAO dao = new MessageDAO();

    private int toInt(String num) {
        return Integer.parseInt(num);
    }

    public void add(String name, String email, String title, String content) {
        try {
            dao.insert(name, email, title, content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> getAllMessage() {
        try {
            return dao.query();
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
}
