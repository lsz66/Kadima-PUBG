package com.kadima.pubg.dao;

import com.kadima.pubg.dto.Message;
import com.kadima.pubg.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MessageDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public List<Message> query() throws SQLException {
        return runner.query("SELECT * FROM message WHERE state = 1", new BeanListHandler<>(Message.class));
    }

    public void insert(String name, String email, String title, String content) throws SQLException {
        runner.update("INSERT INTO message(name, email, title, content) VALUE(?,?,?,?)", name, email, title, content);
    }

    public void delete(int id) throws SQLException {
        runner.update("UPDATE message SET state = 0 WHERE id = ?", id);
    }
}
