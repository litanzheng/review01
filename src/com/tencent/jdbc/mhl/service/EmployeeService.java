package com.tencent.jdbc.mhl.service;

import com.tencent.jdbc.mhl.dao.EmployeeDao;
import com.tencent.jdbc.mhl.domain.Employee;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    public Employee checkEmployee(String id,String pwd){
        String sql = "select * from employee where empid=? and pwd=md5(?)";
        return employeeDao.querySingle(sql,Employee.class,id,pwd);
    }
}
