package com.kadima.pubg.service;

import com.kadima.pubg.dao.VideoDAO;
import com.kadima.pubg.dto.Video;

import java.sql.SQLException;
import java.util.List;

public class VideoService {

    private VideoDAO dao = new VideoDAO();

    private int toInt(String num) {
        return Integer.parseInt(num);
    }

    public List<Video> getAllAvailableVideo() {
        try {
            return dao.queryAvailable();
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

    public void add(int uid, String name, String type, String path) {
        try {
            dao.insert(uid, name, toInt(type), path);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
