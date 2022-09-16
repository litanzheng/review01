package com.tencent.jdbc.dao.dao;

import com.tencent.jdbc.utils.JDBCUtils;
import com.tencent.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Connection connection;
    public int update(String sql,Object... parameters){
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = queryRunner.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    public List<T> queryMuti(String sql,Class<T> tClass,Object... parameteres){
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<>(tClass), parameteres);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    public T querySingle(String sql,Class<T> tClass,Object... parameteres){
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = queryRunner.query(connection, sql, new BeanHandler<>(tClass), parameteres);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    public Object queryScalar(String sql,Object... parameters){
        try {
            connection = JDBCUtilsByDruid.getConnection();
            Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

}
