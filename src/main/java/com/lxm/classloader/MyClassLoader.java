package com.lxm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {

    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("class name:" + name);
        try {
            byte[] classBytes = this.getClassBytes(name);
            return this.defineClass(name, classBytes, 0, classBytes.length);
        } catch (Exception ex) {
            ex.printStackTrace();
            return super.findClass(name);
        }
    }

    private byte[] getClassBytes(String name) throws Exception {
        File file = new File("D://" + "Person.class");
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        try {
            byte[] temp = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(temp)) != -1) {
                bos.write(temp, 0, len);
            }
            return bos.toByteArray();
        } finally {
            inputStream.close();
            bos.close();
        }
    }
}
