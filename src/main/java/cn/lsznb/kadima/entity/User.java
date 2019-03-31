package cn.lsznb.kadima.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private int root;
    private int state;

    public User(String username, String password, int root) {
        this.username = username;
        this.password = password;
        this.root = root;
    }

    public User(int id, String username, String password, int root) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.root = root;
    }
}
