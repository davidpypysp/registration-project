package com.shiping.webstudy.registration.dbutil;

import java.sql.*;

/**
 * Created by shipin on 2015/7/11.
 */
public class JdbcUtils {
    //db username
    private static final String USERNAME = "root";
    //db password
    private static final String PASSWORD = "";
    //driver info
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //db adress
    private static final String URL = "jdbc:mysql://localhost:3306/mydb1";

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * initialization with registration of MySql Driver
     */
    public JdbcUtils() {
        try {
            Class.forName(DRIVER);
            // System.out.println("Connect to mysql success!");
            this.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * obtain db connection
     * @return
     */
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int update(String sql) {
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void release() {
        try {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
