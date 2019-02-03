package cn.lsznb.kadima.service.impl;

import cn.lsznb.kadima.entity.Article;
import cn.lsznb.kadima.mapper.ArticleMapper;
import cn.lsznb.kadima.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper mapper;

    @Override
    public List<Article> queryByCategory(Integer category) {
        return mapper.queryByCategory(category);
    }

    @Override
    public List<Article> getAllNews() {
        return mapper.queryAllNews();
    }

    @Override
    public List<Article> getAllStrategy() {
        return mapper.queryAllStrategy();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void add(Integer uid, String title, Integer type, String content) {
        mapper.insert(uid, title, type, content);
    }

    @Override
    public Article get(Integer id) {
        return mapper.queryById(id);
    }

    @Override
    public void update(Integer id, int uid, String title, Integer category, String content) {
        mapper.update(id, uid, title, category, content);
    }
}
