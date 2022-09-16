package com.tencent.jdbc.myjdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);

        String sql = "update actor set name ='周星驰' where id =1";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i>0?"成功":"失败");

        statement.close();
        connect.close();

    }
}
