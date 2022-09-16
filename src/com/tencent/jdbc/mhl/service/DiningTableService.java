package com.tencent.jdbc.mhl.service;

import com.tencent.jdbc.mhl.dao.DiningTableDao;
import com.tencent.jdbc.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDao diningTableDao = new DiningTableDao();

    public List<DiningTable> list(){
        return diningTableDao.queryMuti("select * from DiningTable", DiningTable.class);
    }

    //注意 sql不要写错 先检查一遍去数据库
    public DiningTable getDiningTableById(int id){
        return diningTableDao.querySingle("select * from DiningTable where id=?",DiningTable.class,id);
    }

    public boolean orderDiningTable(int id,String orderName,String orderTel){
        int update = diningTableDao.update("update DiningTable set state='已经预定',orderName=?,orderTel=? where id =?", orderName, orderTel, id);
        return update>0;
    }

    public boolean updateDiningTableState(int id,String state){
        int update = diningTableDao.update("update DiningTable set state=? where id=?", state, id);
        return update>0;
    }

    public boolean updateDiningTableStateToFree(int id,String state){
        int update = diningTableDao.update("update DiningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update>0;
    }
}
