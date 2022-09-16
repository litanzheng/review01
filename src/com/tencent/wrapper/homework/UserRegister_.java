package com.tencent.wrapper.homework;

//用户注册练习题
public class UserRegister_ {
    public static void main(String[] args) {
        String name = "hhh";
        String pwd = "12345";
        String email = "doag@gda.com";
        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜你注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name,String pwd,String email){
        // if (!(name.length()==2&&name.length()==3&name.length()==4)) 错误
        if (!(name.length()==2&&name.length()==3&name.length()==4)){
            throw new RuntimeException("密码不正确");
        }
        if (!(pwd.length()==6&&isDigit(pwd))){
            throw new RuntimeException("密码格式不对");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i>0&&j>i)){
            throw new RuntimeException("邮箱格式不正确");
        }
    }

    public static boolean isDigit(String pwd){
        boolean temp = false;
        char[] chars = pwd.toCharArray();
        for (char aChar : chars) {
            // if (aChar<0 && aChar>9)  错误的 achar是字符
             if (aChar<'0' && aChar>'9'){
                 return false;
             }
        }
        return true;
    }
}
