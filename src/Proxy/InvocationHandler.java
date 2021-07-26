package Proxy;

import java.lang.reflect.Method;

//持有的被代理对象
public class InvocationHandler<T> implements java.lang.reflect.InvocationHandler {
    T target;

    public InvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
