package Proxy;

import dao.Person;

import java.lang.reflect.Proxy;

public class DynProxyTest {
    public static void main(String[] args) {
        //委托对象Lucy
        Person Lucy = new Student("Lucy");

        //创建一个与代理对象相关的InvocationHandler
        InvocationHandler<Person> stuHandler = new InvocationHandler<>(Lucy);

        //创建代理对象stuProxy
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //通过代理对象调用实际对象的方法
        stuProxy.giveMoney();
    }
}
