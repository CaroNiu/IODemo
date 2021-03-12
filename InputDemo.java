package com.io.ioType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * 输入流区别
 * @author Nuri
 * @CreateTime 2021/3/12
 * @Describe
 */
public class InputDemo {
    public static void main(String[] args) throws Exception {
        writeFile();// 单个字节写 字节数字写
        readFile();// 单个字节读取
        readFile2();// 字节数组读取文件
        readFile3();//一次性读取文件
    }

    static void  writeFile() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("/Users/nuri/Documents/TestFile/writeFile.txt");
        // 单个字节写
        outputStream.write((int)'H');
        outputStream.write((int)'a');
        outputStream.write((int)'g');
        // 字节数组写
        String s = "Helloa";
        outputStream.write(s.getBytes(StandardCharsets.UTF_8));
        // 关闭字节流
        outputStream.flush();
        outputStream.close();
    }

    static void readFile() throws Exception{
        // 单字节读取
        System.out.println("单字节读取。。。");
        FileInputStream inputStream = new FileInputStream("/Users/nuri/Documents/TestFile/ReadFile.txt");
        int by = 0;
        while ((by = inputStream.read())!=-1){
            System.out.print((char) by);
        }
        // 关闭流
        inputStream.close();
    }

    static void readFile2() throws Exception{
        // 字节数组读取 文件
        System.out.println("字节数组读取。。。");
        FileInputStream inputStream = new FileInputStream("/Users/nuri/Documents/TestFile/ReadFile.txt");
        int by =  0;
        byte[] bytes = new byte[10];
        while ((by = inputStream.read(bytes))!=-1){
            for (int i = 0; i < by ; i++) {
                System.out.print((char) bytes[i]);
            }
        }
        inputStream.close();
    }

    static void readFile3() throws Exception{
        // 一次性读取文件
        System.out.println("一次性读取文件。。。");
        FileInputStream inputStream = new FileInputStream("/Users/nuri/Documents/TestFile/ReadFile.txt");
        int available = inputStream.available();
        System.out.println("available:"+available);
        int by = 0;
        byte[] bytes = new byte[available];
        while ((by = inputStream.read(bytes))!= -1){
            for (int i = 0; i < by ; i++) {
                System.out.print((char)bytes[i]);
            }
        }
        inputStream.close();

    }
}
