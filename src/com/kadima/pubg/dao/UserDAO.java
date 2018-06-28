package com.kadima.pubg.dao;

import com.kadima.pubg.dto.User;
import com.kadima.pubg.utils.DBUtil;
import com.kadima.pubg.utils.MD5SaltUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    /**
     * 根据用户名查询实体类
     *
     * @param username 用户名
     * @return 实体类
     */
    public User getDTO(String username) throws SQLException {
        return runner.query("SELECT * FROM user WHERE username = ? AND state = 1",
                new BeanHandler<>(User.class), username);
    }

    /**
     * 查询用户名是否存在，注册时检查用
     *
     * @param username 用户名
     * @return 若存在则返回true
     */
    public boolean check(String username) throws SQLException {
        return getDTO(username) != null;
    }

    /**
     * 根据用户名和密码查询用户，登录用
     *
     * @param username 用户名
     * @param password 密码
     * @param root     用户类别
     * @return 若存在用户名、密码、类别匹配的用户则返回true
     */
    public boolean query(String username, String password, int root) throws SQLException {
        User user = getDTO(username);
        if (user == null)
            return false;
        return MD5SaltUtil.validPassword(password, user.getPassword()) && root == user.getRoot();
    }

    public List<User> queryAll() throws SQLException {
        return runner.query("SELECT * FROM user ORDER BY id DESC", new BeanListHandler<>(User.class));
    }

    /**
     * 添加用户
     *
     * @param username 用户名
     * @param password 密码
     * @param root     用户类别
     * @return 如果用户名不冲突则插入成功，返回true
     */
    public boolean add(String username, String password, int root) throws SQLException {
        if (check(username))
            return false;
        runner.update("INSERT INTO user(username, password, root) VALUE(?,?,?)", username, MD5SaltUtil.getEncryptedPwd(password), root);
        return true;
    }

    /**
     * 根据ID更新用户
     *
     * @param id       要更新的用户的ID
     * @param username 更新的用户名
     * @param password 更新的密码
     * @param root     更新的权限
     */
    public void update(int id, String username, String password, int root) throws SQLException {
        runner.update("UPDATE user SET username = ?, password = ?, root = ? WHERE id = ?", username, MD5SaltUtil.getEncryptedPwd(password), root, id);
    }

    /**
     * 删除用户
     *
     * @param id 要删除的用户ID
     */
    public void delete(int id) throws SQLException {
        runner.update("UPDATE user SET state = 0 WHERE id = ?", id);
    }

    public void active(int id) throws SQLException {
        runner.update("UPDATE user SET state = 1 WHERE id = ?", id);
    }

    /**
     * 根据用户名查询权限
     *
     * @param username 用户名
     * @return 权限值
     */
    public int root(String username) throws SQLException {
        return getDTO(username).getRoot();
    }
}
