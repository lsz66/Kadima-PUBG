package com.kadima.pubg.dao;

import com.kadima.pubg.dto.Video;
import com.kadima.pubg.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class VideoDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public List<Video> query() throws SQLException {
        return runner.query("SELECT * FROM video", new BeanListHandler<>(Video.class));
    }

    public List<Video> queryAvailable() throws SQLException {
        return runner.query("SELECT * FROM video WHERE state = 1", new BeanListHandler<>(Video.class));
    }

    public Video queryById(int id) throws SQLException {
        return runner.query("SELECT * FROM video WHERE id = ?", new BeanHandler<>(Video.class), id);
    }

    public void insert(int uid, String name, int type, String path) throws SQLException {
        runner.update("INSERT INTO video(uid, name, type, path) VALUE(?,?,?,?)", uid, name, type, path);
    }

    public void delete(int id) throws SQLException {
        runner.update("UPDATE video SET state = 0 WHERE id = ?", id);
    }

    public void update(int id, int uid, String name, int type, String path) throws SQLException {
        runner.update("UPDATE video SET uid = ?, name = ?, type = ?, path = ? WHERE id = ?", uid, name, type, path);
    }
}
