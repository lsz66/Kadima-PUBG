package cn.lsznb.kadima.mapper;

import cn.lsznb.kadima.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username} AND state = 1")
    User getDTO(String username);

    @Select("SELECT COUNT(*) FROM user WHERE username = #{username} AND state = 1")
    boolean check(String username);

    @Select("SELECT COUNT(*) FROM user WHERE username = #{username} AND password = #{password} AND root = 1 AND state = 1")
    boolean query(User user);

    @Select("SELECT * FROM user ORDER BY id DESC")
    List<User> queryAll();

    @Insert("INSERT INTO user(username, password, root) VALUE (#{username}, #{password}, #{root})")
    boolean add(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, root = #{root} WHERE id = #{id}")
    void update(User user);

    @Update("UPDATE user SET state = 0 WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE user SET state = 1 WHERE id = #{id}")
    void active(int id);

    @Select("SELECT root FROM user WHERE username = #{username}")
    int root(String username);
}
