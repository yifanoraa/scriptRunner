package com.yliu.elasticjob;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootTest
class ElasticjobApplicationTests {

    public static void main(String[] args){
        System.out.println("Get started");
        Connection conn;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mytest?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "password";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            // 分别写入
            insertData(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void insertData(Connection conn) throws SQLException {
        String sql = "INSERT INTO `testuser` VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        int startArg = 1;
        for(int i = 1;i <= 10000;i++){
            stmt.setInt(1, startArg);
            stmt.setInt(2, startArg);
            startArg++;
            stmt.execute();
        }
    }

}
