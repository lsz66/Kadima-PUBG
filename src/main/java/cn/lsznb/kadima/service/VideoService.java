package cn.lsznb.kadima.service;

import cn.lsznb.kadima.entity.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAllAvailableVideo();

    void delete(Integer id);

    void add(Integer uid, String name, Integer type, String path);
}
