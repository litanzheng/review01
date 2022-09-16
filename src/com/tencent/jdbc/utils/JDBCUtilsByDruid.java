package com.tencent.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {

    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
//            properties.load(new FileInputStream("src//durid.properties"));
            InputStream resourceAsStream = JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("durid.properties");
            properties.load(resourceAsStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new JDBCUtilsByDruid();
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    //这里关闭不是真正断掉连接 而是把connection对象放入连接池
    public static void close(ResultSet set, Statement statement,Connection connection){
        try {
            if (set!=null){
                set.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
