package com.tencent.abstract_;

public class AA extends Template{


//    public void caculate(){
//        long start = System.currentTimeMillis();
//        job();
//        long end = System.currentTimeMillis();
//        System.out.println("AA运行时间:"+(end - start));
//    }
    public void job(){

        long num = 0;
        for (int i = 0; i <= 6000000; i++) {
            num +=i;
        }

    }
}
