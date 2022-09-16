package com.tencent.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\reflection.properties"));

        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        System.out.println(classfullpath);
        System.out.println(method);

        Class<?> aClass = Class.forName(classfullpath);
        //编译类型
        System.out.println(aClass);
        //运行类型
        System.out.println(aClass.getClass());
        Object o = aClass.newInstance();
        System.out.println(o.getClass());

        Method method1 = aClass.getMethod(method);
        method1.invoke(o);

        Field name = aClass.getField("age");
        System.out.println(name.get(o));

        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor1);


    }
}
