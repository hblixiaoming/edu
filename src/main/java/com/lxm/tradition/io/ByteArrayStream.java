package com.lxm.tradition.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStream {

    public void testInput(){
        String words = "Hello World";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(words.getBytes());
        StringBuilder builder = new StringBuilder();
        int temp;
        while ((temp = inputStream.read())!=-1){
            builder.append(temp);
        }
        System.out.println(builder.toString());
    }

    public void testOutput()throws Exception{
        String words = "Hello World";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for(byte temp:words.getBytes()){
            outputStream.write(temp);
        }
        byte[] container = outputStream.toByteArray();
        System.out.println(new String(container,"UTF-8"));
    }
    public static void main(String[] args)throws Exception{
        ByteArrayStream test = new ByteArrayStream();
        test.testInput();
        test.testOutput();
    }

}
