package Proxy;

import dao.Person;

public class StudentProxy implements Person {
    //代理类

    Student student;
    //委托的学生

    public StudentProxy(Person stu) {
        //只代理学生类
        if (stu.getClass() == Student.class) {
            this.student = (Student) stu;
        }
    }

    @Override
    //代理类对象本身不实现服务 而是调用委托类的对象方法
    public void giveMoney() {
        student.giveMoney();
    }
}
