package com.tencent.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCUtils_Use {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update actor set name =? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"刘德华");
        preparedStatement.setInt(2,1);
        int i = preparedStatement.executeUpdate();
        System.out.println(1>0? "成功":"失败");
        JDBCUtils.close(null,preparedStatement,connection);
    }

    @Test
    public void testSelect(){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from actor";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+date+"\t"+phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }

    }
}
