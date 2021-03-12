package com.io.ioType;

import java.io.*;

/**
 * 缓存字节流
 * BufferedInputStream 是带缓冲区的，在复制、移动文件操作会快一点
 * Java使用IO 读取文件时，会进入核心态，在调用驱动进行IO，本身就会缓存在系统级别的，当你第二次读取时，会由用户态进入核心态，读取系统缓存。BufferedInputStream就一次性读取较多，缓存起来。
 * @author Nuri
 * @CreateTime 2021/3/12
 * @Describe
 */
public class StreamWithCache {
    public static void main(String[] args) throws Exception{
        useInputStreamCopeFile();
        useBufferStreamCopyFile();

    }

    /**
     * 使用字节流复制文件
     * @throws Exception
     */
    static void useInputStreamCopeFile() throws Exception{
        System.out.println("使用字节流复制文件...");
        File file = new File("/Users/nuri/Documents/TestFile/1.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        File file1 = new File("/Users/nuri/Documents/TestFile/1-copy.jpg");
        FileOutputStream outputStream = new FileOutputStream(file1);
        int len  =  0;
        byte[] bytes = new byte[1024];
        while ((inputStream.read(bytes))!=-1){
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();
    }

    static void useBufferStreamCopyFile() throws Exception{
        System.out.println("使用带缓存的复制文件...");
        FileInputStream inputStream = new FileInputStream("/Users/nuri/Documents/TestFile/1.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream outputStream = new FileOutputStream("/Users/nuri/Documents/TestFile/1-copy2.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((bufferedInputStream.read(bytes))!= -1){
            bufferedOutputStream.write(bytes);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

}
