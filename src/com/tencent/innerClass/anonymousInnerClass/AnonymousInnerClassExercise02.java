package com.tencent.innerClass.anonymousInnerClass;

public class AnonymousInnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒虫起床啦");
            }
        });
       cellPhone.alarmClock(new Bell() {
           @Override
           public void ring() {
               System.out.println("小伙伴上课啦");
           }
       });

    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) {
        System.out.println(bell.getClass());
        bell.ring();
    }
}