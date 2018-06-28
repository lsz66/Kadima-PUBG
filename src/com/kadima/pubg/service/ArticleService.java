package com.kadima.pubg.service;

import com.kadima.pubg.dao.ArticleDAO;
import com.kadima.pubg.dto.Article;

import java.sql.SQLException;
import java.util.List;

public class ArticleService {

    private ArticleDAO dao = new ArticleDAO();

    private int toInt(String num) {
        return Integer.parseInt(num);
    }

    public List<Article> queryByCategory(String category) {
        try {
            return dao.queryByCategory(toInt(category));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article> getAllNews() {
        try {
            return dao.queryAllNews();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article> getAllStrategy() {
        try {
            return dao.queryAllStrategy();
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

    public void add(int uid, String title, String type, String content) {
        try {
            dao.insert(uid, title, toInt(type), content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Article get(String id) {
        try {
            return dao.queryById(toInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String id, int uid, String title, String category, String content) {
        try {
            dao.update(toInt(id), uid, title, toInt(category), content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
