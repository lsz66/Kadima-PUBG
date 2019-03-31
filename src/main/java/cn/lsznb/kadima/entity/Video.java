package cn.lsznb.kadima.entity;

import lombok.Data;

@Data
public class Video {
    private int id;
    private int uid;
    private String name;
    private int type;
    private String path;
    private String time;
    private int state;
}
