package cn.lsznb.kadima.entity;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String name;
    private String email;
    private String title;
    private String content;
}
