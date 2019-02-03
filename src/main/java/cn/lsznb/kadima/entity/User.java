package cn.lsznb.kadima.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private int root;
    private int state;

    public User() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", root=" + root +
                ", state=" + state +
                '}';
    }
}
