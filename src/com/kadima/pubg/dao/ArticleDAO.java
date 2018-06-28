package com.kadima.pubg.dao;

import com.kadima.pubg.dto.Article;
import com.kadima.pubg.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ArticleDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public List<Article> query() throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE uid = user.id ORDER BY id DESC", new BeanListHandler<>(Article.class));
    }

    public List<Article> queryAvailable() throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE article.state = 1 AND uid = user.id ORDER BY id DESC", new BeanListHandler<>(Article.class));
    }

    public List<Article> queryByCategory(int category) throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category = ? AND article.state = 1 AND uid = user.id ORDER BY id DESC", new BeanListHandler<>(Article.class), category);
    }

    public List<Article> queryAllNews() throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category <= 3 AND article.state = 1 AND uid = user.id ORDER BY id DESC", new BeanListHandler<>(Article.class));
    }

    public List<Article> queryAllStrategy() throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category > 3 AND article.state = 1 AND uid = user.id ORDER BY id DESC", new BeanListHandler<>(Article.class));
    }

    public Article queryById(int id) throws SQLException {
        return runner.query("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE article.id = ? AND article.state = 1 AND uid = user.id", new BeanHandler<>(Article.class), id);
    }

    public void insert(int uid, String title, int category, String content) throws SQLException {
        runner.update("INSERT INTO article(uid, title, category, content) VALUE(?,?,?,?)", uid, title, category, content);
    }

    public void delete(int id) throws SQLException {
        runner.update("UPDATE article SET state = 0 WHERE id = ?", id);
    }

    public void update(int id, int uid, String title, int category, String content) throws SQLException {
        runner.update("UPDATE article SET uid = ?, title = ?, category = ?, content = ? WHERE id = ?",
                uid, title, category, content, id);
    }
}
