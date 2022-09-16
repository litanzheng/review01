package com.tencent.jdbc.datasource;

import com.tencent.jdbc.utils.Actor;
import com.tencent.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_Use {

    @Test
    public void testQueryMany() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id >=?";
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        for (Actor actor : list) {
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(null,null,connection);
    }

    //查询单行
    @Test
    public void testQuerSingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id =?";
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);
        JDBCUtilsByDruid.close(null,null,connection);
    }

    //查询单行单列
    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id =?";
        Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(query);
        JDBCUtilsByDruid.close(null,null,connection);
    }

    @Test
    public void testDMl() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update actor set name = ? where id =?";
        int update = queryRunner.update(connection, sql, "张三丰", 1);
        System.out.println(update);
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
