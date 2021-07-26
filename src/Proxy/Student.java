package Proxy;

import dao.Person;

public class Student implements Person {
    //委托类

    private String name;

    public Student(String name){
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
