package Proxy;

import dao.Person;

public class StaticProxyTest {
    public static void main(String[] args) {
        //委托对象Lucy
        Person Lucy = new Student("Lucy");

        //生成代理对象monitor, 代Lucy交班费
        Person monitor = new StudentProxy(Lucy);

        //通过代理对象调用实际对象的方法
        monitor.giveMoney();
    }
}
