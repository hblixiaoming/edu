package com.lxm.proxy.autoProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Person zhangsan = new Student("zhangsan");
        InvocationHandler handler = new StuInvocationHandler<Person>(zhangsan);
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        stuProxy.giveMoney();
    }
}
