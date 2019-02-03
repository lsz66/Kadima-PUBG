package cn.lsznb.kadima.mapper;

import cn.lsznb.kadima.entity.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("SELECT * FROM video")
    List<Video> query();

    @Select("SELECT * FROM video WHERE state = 1")
    List<Video> queryAvailable();

    @Select("SELECT * FROM video WHERE id = #{id}")
    Video queryById(int id);

    @Insert("INSERT INTO video(uid, name, type, path) VALUE(#{uid}, #{name}, #{type}, #{path})")
    void insert(int uid, String name, int type, String path);

    @Update("UPDATE video SET state = 0 WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE video SET uid = #{uid}, name = #{name}, type = #{type}, path = #{path} WHERE id = #{id}")
    void update(int id, int uid, String name, int type, String path);
}
