package cn.lsznb.kadima.mapper;

import cn.lsznb.kadima.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE uid = user.id ORDER BY id DESC")
    List<Article> query();

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE article.state = 1 AND uid = user.id ORDER BY id DESC")
    List<Article> queryAvailable();

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category = #{category} AND article.state = 1 AND uid = user.id ORDER BY id DESC")
    List<Article> queryByCategory(int category);

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category <= 3 AND article.state = 1 AND uid = user.id ORDER BY id DESC")
    List<Article> queryAllNews();

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE category > 3 AND article.state = 1 AND uid = user.id ORDER BY id DESC")
    List<Article> queryAllStrategy();

    @Select("SELECT article.id, username, title, category, content, time, article.state FROM article, user WHERE article.id = #{id} AND article.state = 1 AND uid = user.id")
    Article queryById(int id);

    @Insert("INSERT INTO article(uid, title, category, content) VALUE(#{uid}, #{title}, #{category}, #{content})")
    void insert(int uid, String title, int category, String content);

    @Update("UPDATE article SET state = 0 WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE article SET uid = #{uid}, title = #{title}, category = #{category}, content = #{content} WHERE id = #{id}")
    void update(int id, int uid, String title, int category, String content);
}
