package com.tencent.generic_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork {
    public static void main(String[] args) {
        Dao<User> userDao = new Dao<>();
        userDao.save("001",new User(1,12,"jack"));
        userDao.save("002",new User(2,13,"jim"));
        userDao.save("003",new User(3,14,"john"));
        List<User> list = userDao.list();
        System.out.println(list);
        userDao.update("003",new User(4,14,"hhh"));
        userDao.delete("001");
        list = userDao.list();
        System.out.println(list);
    }
}

class Dao<T>{
    Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.put(id,entity);
    }

    public List<T> list(){
        List<T> list = new ArrayList();
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "{" +
                 map +
                '}';
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User(" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ')';
    }
}