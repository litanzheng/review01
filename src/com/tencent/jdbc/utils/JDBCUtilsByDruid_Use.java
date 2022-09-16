package com.tencent.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtilsByDruid_Use {

    @Test
    public void selectTest(){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList<>();
        try {
            connection = JDBCUtilsByDruid.getConnection();
            String sql = "select * from actor";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                list.add(new Actor(id,name,sex,date,phone));
                System.out.println(list);
//                System.out.println(id+"\t"+name+"\t"+sex+"\t"+date+"\t"+phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);
        }

    }

}
