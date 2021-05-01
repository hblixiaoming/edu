package com.lxm.test;

public class TestBasic {

    static class Animal {
        static String name = "动物";
        int age = 23;

        static void print() {
            System.out.println(name);
        }

    }

    static class Dog extends Animal {
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.print();
    }
}
