package com.tencent.wrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Date_01 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年mm月dd日 HH小时mm分钟ss秒");
        String format = dateTimeFormatter.format(ldt);
        System.out.println(format);
    }
}
