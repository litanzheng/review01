package com.tencent.interface_.interface02;

public class OracleDB implements DBInterface{
    @Override
    public void connection() {
        System.out.println("Oracle连接");
    }

    @Override
    public void close() {
        System.out.println("Oracle关闭");
    }
}
