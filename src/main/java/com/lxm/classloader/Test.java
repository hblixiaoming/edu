package com.lxm.classloader;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Class clazz = Class.forName("com.lxm.classloader.Person", true, loader);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("getName", null);
        System.out.println(method.invoke(obj, null));
        System.out.println(clazz.getClassLoader().toString());
    }
}
