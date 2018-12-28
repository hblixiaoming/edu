package com.lxm.proxy.staticProxy;

public class StudentProxy implements Person {

    private Person person;

    public StudentProxy(Person person) {
        this.person = person;
    }

    @Override
    public void giveMoney() {
        System.out.println("before give money");
        person.giveMoney();
        System.out.println("after give money");
    }
}
