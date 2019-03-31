package cn.lsznb.kadima.entity;

import lombok.Data;

@Data
public class Article {
    private int id;
    private String username;
    private String title;
    private int category;
    private String content;
    private String time;
    private int state;
}
