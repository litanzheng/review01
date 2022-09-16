package com.tencent.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        Season2 spring = Season2.Spring;
//        System.out.println(spring.getClass());
//        System.out.println(spring.name());
//        System.out.println(spring.ordinal());
//        for (Season2 season2 : Season2.values()) {
//            System.out.println(season2);
//        }
        //把字符串转成枚举类型 注意这里的字符串必须是在枚举里的否则会报错
        Season2 season2 = Season2.valueOf("Winter");
        System.out.println(season2);
        //这里的compareTo比较的是位置号
        System.out.println(season2.compareTo(spring));
        String a = "jack";
        String b = "jac";
        System.out.println(a.compareTo(b));
    }
}

enum Season2{
    Spring("春天","温暖"),Summer("夏天","炎热"),Autumn("秋天","温暖"),Winter("冬天","温暖");
    private String name;
    private String desc;

    Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}