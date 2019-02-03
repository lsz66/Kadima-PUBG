package cn.lsznb.kadima.service.impl;

import cn.lsznb.kadima.entity.Video;
import cn.lsznb.kadima.mapper.VideoMapper;
import cn.lsznb.kadima.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper mapper;

    @Override
    public List<Video> getAllAvailableVideo() {
        return mapper.queryAvailable();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void add(Integer uid, String name, Integer type, String path) {
        mapper.insert(uid, name, type, path);
    }
}
