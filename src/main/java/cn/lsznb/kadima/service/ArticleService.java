package cn.lsznb.kadima.service;

import cn.lsznb.kadima.entity.Article;

import java.util.List;

/**
 * @author 李尚哲
 */
public interface ArticleService {

    List<Article> queryByCategory(Integer category);

    List<Article> getAllNews();

    List<Article> getAllStrategy();

    void delete(Integer id);

    void add(Integer uid, String title, Integer type, String content);

    Article get(Integer id);

    void update(Integer id, int uid, String title, Integer category, String content);
}
