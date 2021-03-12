package com.io.ioType;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流读写
 * @author Nuri
 * @CreateTime 2021/3/12
 * @Describe
 */
public class ReaderDemo {
    public static void main(String[] args) throws Exception{
        write();
        read1();
        read2();
    }

    static void write() throws Exception{
        System.out.println("字符流写文件。。。。");
        FileWriter fileWriter = new FileWriter("/Users/nuri/Documents/TestFile/writeFile.txt");
        fileWriter.write("今天打工你不狠，明天地位就不稳\n" + "今天打工不勤快，明天就被社会淘汰！");
        fileWriter.flush();// 如果没有刷新 或者关闭流，不会写到文件中
        fileWriter.close();
    }

    static void read1() throws Exception{
        System.out.println("一个一个char的读取。。。");
        FileReader fileReader = new FileReader("/Users/nuri/Documents/TestFile/writeFile.txt");
        int ch = 0;
        String str = "";
        while ((ch = fileReader.read())!=-1){
            str+=(char)ch;
        }
        System.out.println(str);
    }

    static void read2() throws Exception{
        System.out.println("char数组读取。。。");
        FileReader fileReader = new FileReader("/Users/nuri/Documents/TestFile/writeFile.txt");
        int ch = 0;
        char[] bytes = new char[10];
        while ((ch = fileReader.read(bytes))!=-1){
            System.out.print(new String(bytes,0,ch));
        }
        fileReader.close();
    }

}
