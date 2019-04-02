package cn.lsznb.kadima.service.impl;

import cn.lsznb.kadima.entity.Message;
import cn.lsznb.kadima.mapper.MessageMapper;
import cn.lsznb.kadima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;

    @Override
    public String add(String name, String email, String title, String content) {
        if (name.length() == 0 || email.length() == 0 || title.length() == 0 || content.length() == 0) {
            return "0";
        } else {
            mapper.insert(name, email, title, content);
            return "1";
        }
    }

    @Override
    public List<Message> getAllMessage() {
        return mapper.query();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
