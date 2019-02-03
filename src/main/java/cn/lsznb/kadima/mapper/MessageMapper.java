package cn.lsznb.kadima.mapper;

import cn.lsznb.kadima.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM message WHERE state = 1")
    List<Message> query();

    @Insert("INSERT INTO message(name, email, title, content) VALUE(#{name}, #{email}, #{title}, #{content})")
    void insert(String name, String email, String title, String content);

    @Update("UPDATE message SET state = 0 WHERE id = #{id}")
    void delete(int id);
}
