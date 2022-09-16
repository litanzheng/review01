package com.tencent.jdbc.mhl.view;

import com.tencent.jdbc.mhl.domain.Bill;
import com.tencent.jdbc.mhl.domain.DiningTable;
import com.tencent.jdbc.mhl.domain.Employee;
import com.tencent.jdbc.mhl.domain.Menu;
import com.tencent.jdbc.mhl.service.BillService;
import com.tencent.jdbc.mhl.service.DiningTableService;
import com.tencent.jdbc.mhl.service.EmployeeService;
import com.tencent.jdbc.mhl.service.MenuService;
import com.tencent.jdbc.mhl.utils.Utils;

import java.util.List;

public class MHLView {
    private boolean loop=true;
    private String key ="";

    private EmployeeService employeeService = new EmployeeService();

    private DiningTableService diningTableService = new DiningTableService();

    private MenuService menuService = new MenuService();

    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }


    public void payBill(){
        System.out.println("结账服务");
        System.out.println("请选择结账餐桌编号");
        int diningTableId= Utils.readInt();
        DiningTable diningTableById = diningTableService.getDiningTableById(diningTableId);
        if (diningTableById==null){
            System.out.println("餐桌不存在");
            return;
        }
        if (!(billService.unPaiedBill(diningTableId))){
            System.out.println("没有要结账的账单");
            return;
        }
        System.out.println("请选择结账方式");
        String state=Utils.readString();
        if (billService.payBill(diningTableId,state)){
            System.out.println("结账成功");
        }else {
            System.out.println("结账失败");
        }

    }
    public void listBill(){
        List<Bill> list = billService.list();
        for (Bill bill : list) {
            System.out.println(bill);
        }
    }
    public void orderMenu(){
        System.out.println("点餐服务");
        System.out.println("请输入点餐的桌号");
        int diningtableId = Utils.readInt();
        System.out.println("请输入点餐菜品号");
        int menuId = Utils.readInt();
        System.out.println("请输入点餐的数量");
        int nums = Utils.readInt();

        DiningTable diningTableById = diningTableService.getDiningTableById(diningtableId);
        if (diningTableById == null){
            System.out.println("餐桌不存在");
            return;
        }
        Menu menuById = menuService.getMenuById(menuId);
        if (menuById ==null){
            System.out.println("菜品不存在");
            return;
        }
        if (billService.orderMenu(menuId,nums,diningtableId)){
            System.out.println("点餐成功");
        }else {
            System.out.println("点餐失败");
        }

    }

    public void listMenu(){
        List<Menu> list = menuService.list();
        System.out.println("菜品编号\t菜品名\t菜品类别\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }
    public void orderDiningTable(){
        System.out.println("预定餐桌");
        System.out.println("请选择要预定的餐桌号(-1退出)");
        int id = Utils.readInt();
        if (id==-1){
            System.out.println("放弃预定");
            return;
        }
        char c = Utils.readChar();
        if (c=='Y'){
            DiningTable diningTable = diningTableService.getDiningTableById(id);
            if (diningTable == null){
                System.out.println("餐桌不存在");
                return;
            }
            if (!("空".equals(diningTable.getState()))){
                System.out.println("餐桌已预定");
                return;
            }
            System.out.println("请输入预订人姓名:");
            String orderName = Utils.readString();
            System.out.println("请输入预定人电话:");
            String orderTel = Utils.readString();
            diningTableService.orderDiningTable(id,orderName,orderTel);

        }else {
            System.out.println("放弃预定");
            return;
        }
    }
    public void mainMenu(){
        while (loop){
            System.out.println("====满汉楼登录页面====");
            System.out.println("\t\t  1登录满汉楼");
            System.out.println("\t\t  2退     出");
            System.out.println("请输入您的选择:");
            key = Utils.readString();
            switch (key){
                case "1":
                    System.out.println("请输入员工号");
                    String id = Utils.readString();
                    System.out.println("请输入密码");
                    String pwd = Utils.readString();
                    Employee employee = employeeService.checkEmployee(id, pwd);
                    if (employee!=null){
                        System.out.println("欢迎"+employee.getName()+"登录成功");
                        while (loop){
                            System.out.println("====满汉楼二级菜单====");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出");
                            System.out.println("请输入您的选择[1-9]:");
                            key = Utils.readString();
                            switch (key){
                                case "1":
                                    List<DiningTable> list = diningTableService.list();
                                    System.out.println("餐桌编号   \t餐桌状态");
                                    for (DiningTable diningTable : list) {
                                        System.out.println(diningTable);
                                    }
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你的输入有误,重新输入");
                            }
                        }
                    }else {
                        System.out.println("登录失败");
                    }


                    break;
                case "2":
                    System.out.println("退出满汉楼");
                    loop=false;
                    break;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}
