package com.tencent.reflection.class_;

import java.lang.reflect.Field;

//class常用方法
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classPath = "com.tencent.reflection.class_.Car";
        Class<?> aClass = Class.forName(classPath);

        System.out.println(aClass);  //显示 aClass 是那个类的Class对象
        System.out.println(aClass.getClass()); // 输出aClass运行类型

        System.out.println(aClass.getPackage().getName());
        System.out.println(aClass.getName());


        Car car = (Car) aClass.newInstance();
        System.out.println(car);

        Field brand = aClass.getField("brand");
        System.out.println(brand);
        System.out.println(brand.get(car));

        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
