package com.tencent.enum_;

import javax.swing.*;

public class Enumeration01 {

}
//自定义实现枚举
class Season{
    private String name;
    private String desc;

    public static final Season Spring = new Season("春天","温暖");
    public static final Season Summer = new Season("夏天","温暖");
    public static final Season Autumn = new Season("秋天","温暖");
    public static final Season Winter = new Season("冬天","温暖");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}