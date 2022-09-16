package com.tencent.internet.qq.qqclient.view;

import com.tencent.internet.qq.qqclient.service.FileClientService;
import com.tencent.internet.qq.qqclient.service.MessageClientService;
import com.tencent.internet.qq.qqclient.service.UserClientService;
import com.tencent.internet.qq.qqclient.utils.Utils;
import org.junit.platform.commons.util.StringUtils;

public class QQView {
    private boolean loop = true;
    private String key= "";

    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();
    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("退出网络通讯系统");
    }

    public void mainMenu(){
        while (loop){
            System.out.println("欢迎进入网路通讯系统");
            System.out.println("\t\t 1 用户登录");
            System.out.println("\t\t 9 用户退出");
            System.out.println("请输入你的选择");
            key = Utils.readString();
            switch (key){
                case "1":
                    System.out.println("请输入用户名");
                    String uid = Utils.readString();
                    System.out.println("请输入密码");
                    String pwd= Utils.readString();
                    if (userClientService.checkUser(uid,pwd)){
                        System.out.println("欢迎用户"+uid+"登录成功");
                        while (loop){
                            System.out.println("\n欢迎进入网络通信二级菜单");
                            System.out.println("\t\t  1 显示用户列表");
                            System.out.println("\t\t  2 群发消息");
                            System.out.println("\t\t  3 私聊消息");
                            System.out.println("\t\t  4 发送文件");
                            System.out.println("\t\t  9 退出系统");
                            System.out.println("请输入您的选择:");
                            key = Utils.readString();
                            switch (key){
                                case "1":
                                    userClientService.getOnlineFriend();
                                    break;
                                case "2":
                                    System.out.println("请输入要对大家说的话");
                                    String s = Utils.readString();
                                    messageClientService.sendMessageToAll(s,uid);
                                    break;
                                case "3":
                                    System.out.println("请输入要聊天的用户名:");
                                    String getterId = Utils.readString();
                                    System.out.println("请输入要聊天的内容:");
                                    String content = Utils.readString();
                                    System.out.println("私聊消息");
                                    messageClientService.sendMessageToOne(content,uid,getterId);
                                    break;
                                case "4":
                                    System.out.println("请输入要发送文件的用户ID");
                                    String getterid = Utils.readString();
                                    System.out.println("请输入要发送文件的路径 e:\\xxx.png");
                                    String src = Utils.readString();
                                    System.out.println("请输入要发送文件的对应路径 d:\\xxx.png");
                                    String desc = Utils.readString();
                                    fileClientService.sendFileToOne(src,desc,uid,getterid);
                                    break;
                                case "5":
                                    break;
                                case "9":
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else {
                        System.out.println("登录失败");
                    }
                    break;
                case "2":
                    loop = false;
                    break;

            }
        }
    }
}
