package com.tencent.abstract_;

public class BB extends Template{

//    public void caculate(){
//        long start = System.currentTimeMillis();
//        job();
//        long end = System.currentTimeMillis();
//        System.out.println("BB运行时间:"+(end - start));
//    }
    public void job(){
        long num = 0;
        for (int i = 0; i <= 10000000; i++) {
            num +=i;
        }
    }
}
