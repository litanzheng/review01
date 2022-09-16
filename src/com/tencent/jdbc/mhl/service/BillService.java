package com.tencent.jdbc.mhl.service;

import com.tencent.jdbc.mhl.dao.BillDao;
import com.tencent.jdbc.mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

public class BillService {
    private BillDao billDao = new BillDao();
    private MenuService menuService = new MenuService();

    private DiningTableService diningTableService = new DiningTableService();

    public boolean orderMenu(int menuID,int nums,int diningTableId){
        //生成一个账单号
        String billID = UUID.randomUUID().toString();
        String sql = "insert into bill values(null,?,?,?,?,?,now(),'未结账')";
        int update = billDao.update(sql, billID, menuID, nums, menuService.getMenuById(menuID).getPrice() * nums, diningTableId);
        if (update<=0){
            return false;
        }
        return diningTableService.updateDiningTableState(diningTableId,"就餐中");
    }

    public List<Bill> list(){
        return billDao.queryMuti("select* from bill",Bill.class);
    }

    public boolean unPaiedBill(int diningTableId){
        Bill bill = billDao.querySingle("select * from bill where  state='未结账' and diningTableId=? limit 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    public boolean payBill(int diningTableId,String state) {
        int update = billDao.update("update bill set state=? where diningTableId=? and state='未结账'", state, diningTableId);
        if (update <= 0) {
            return false;
        }

        if (!(diningTableService.updateDiningTableStateToFree(diningTableId,"空"))){
            return false;
        }
        return true;

    }
}
