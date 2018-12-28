package com.lxm.proxy.staticProxy;

public class ProxyTest {
    public static void main(String[] args){
        Person zhangsan = new Student("zhangsan");

        StudentProxy proxy = new StudentProxy(zhangsan);

        proxy.giveMoney();

    }
}
