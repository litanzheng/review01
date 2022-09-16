package com.tencent.abstract_;

public abstract class Template {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("AA运行时间:" + (end - start));
    }

    public abstract void job();
}
