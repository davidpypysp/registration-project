package com.shiping.webstudy.registration.dao.impl;

import com.shiping.webstudy.registration.dao.SystemDao;
import com.shiping.webstudy.registration.dbutil.JdbcUtils;
import com.shiping.webstudy.registration.model.po.UserPo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shipin on 2015/7/11.
 */
public class SystemDaoImpl implements SystemDao {
    @Override
    public boolean userNameExisted(String username) {
        boolean flag = false;
        String sql = "select count(*) from users where username = '" + username + "';";
        JdbcUtils jdbc = new JdbcUtils();
        ResultSet rs = jdbc.query(sql);
        try {
            if(rs.next())
                if(rs.getInt("count(*)") != 0) flag = true;
            rs.close();
            jdbc.release();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insertUser(UserPo userpo) {
        boolean flag = false;
        String sql = "insert into users values('"
                + userpo.getUsername() + "','"
                + userpo.getNickname() + "','"
                + userpo.getPassword() + "','"
                + userpo.getEmail() + "','"
                + userpo.getSex() + "');";
        JdbcUtils jdbc = new JdbcUtils();
        if(jdbc.update(sql) > 0)
            flag = true;
        jdbc.release();
        return flag;
    }

    @Override
    public boolean updateUser(UserPo userpo) {
        if( userNameExisted(userpo.getUsername()) == false )
            return false;
        boolean flag = false;
        String sql = "update users set "
                + "nickname = '" + userpo.getNickname() + "', "
                + "password = '" + userpo.getPassword() + "', "
                + "email = '" + userpo.getEmail() + "', "
                + "sex = '" + userpo.getSex() + "'"
                + "where username = '" + userpo.getUsername() + "';";
        JdbcUtils jdbc = new JdbcUtils();
        if( jdbc.update(sql) > 0)
            flag = true;
        jdbc.release();
        return flag;
    }

    @Override
    public UserPo getUserByName(String username) {
        if(userNameExisted(username) == false)
            return null;
        String sql = "select * from users where username = '" + username + "';";
        JdbcUtils jdbc = new JdbcUtils();
        ResultSet rs = jdbc.query(sql);
        UserPo userpo = null;
        try {
            if(rs.next()) {
                userpo = new UserPo();
                userpo.setUsername(rs.getString("username"));
                userpo.setNickname(rs.getString("nickname"));
                userpo.setPassword(rs.getString("password"));
                userpo.setEmail(rs.getString("email"));
                userpo.setSex(rs.getString("sex"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbc.release();
        return userpo;
    }
}
