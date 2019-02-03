package cn.lsznb.kadima.service;

import cn.lsznb.kadima.entity.Message;

import java.util.List;

public interface MessageService {

    String add(String name, String email, String title, String content);

    List<Message> getAllMessage();

    void delete(Integer id);
}
