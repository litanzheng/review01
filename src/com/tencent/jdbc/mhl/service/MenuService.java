package com.tencent.jdbc.mhl.service;

import com.tencent.jdbc.mhl.dao.MenuDao;
import com.tencent.jdbc.mhl.domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao = new MenuDao();

    public List<Menu> list(){
        return menuDao.queryMuti("select * from menu",Menu.class);
    }

    public Menu getMenuById(int id){
        return menuDao.querySingle("select * from menu where id=?",Menu.class,id);
    }
}
