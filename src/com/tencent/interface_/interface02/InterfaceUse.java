package com.tencent.interface_.interface02;

public class InterfaceUse {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();
        work(mysqlDB);
        work(oracleDB);
        //普通方法应用接口
        InterfaceUse interfaceUse = new InterfaceUse();
        interfaceUse.work2(mysqlDB);
    }
    public static void work(DBInterface dbInterface){
        dbInterface.connection();
        dbInterface.close();
    }

    public void work2(DBInterface dbInterface){
        dbInterface.connection();
        dbInterface.close();
    }
}
