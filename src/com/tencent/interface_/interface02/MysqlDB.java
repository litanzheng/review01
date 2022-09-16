package com.tencent.interface_.interface02;

public class MysqlDB implements DBInterface{
    @Override
    public void connection() {
        System.out.println("Mysql连接");
    }

    @Override
    public void close() {
        System.out.println("Mysql关闭");
    }
}
