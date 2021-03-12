package com.io.ioType;

import java.io.*;

/**
 * BufferedReader、BufferedWriter 字符缓冲流
 * 总结：
 *  1.字节流是原生的操作，字符流是经过处理后的操作。
 *  2.输入：Reader, InputStream类型的子类输出：Writer, OutputStream类型的子类
 *  3、字节流一般用来处理图像、视频、音频、PPT、Word等类型的文件。字符流一般用于处理纯文本类型的文件，如TXT文件等，但不能处理图像视频等非文本文件。用一句话说就是：字节流可以处理一切文件，而字符流只能处理纯文本文件。含有汉子的文件就使用字符流处理。
 *  4、需要转换？是，使用转换流 bufferedInputStream bufferedOutputStream bufferedReader bufferedWriter；是否需要高效，使用缓冲流。
 *  5、使用流之后一定要close()
 *
 * @author Nuri
 * @CreateTime 2021/3/12
 * @Describe
 */
public class BufferWithCache {
    public static void main(String[] args) throws Exception{
        useBufferedReaderCopyFile();
        useFileReaderCopyFile();
    }

    static void useBufferedReaderCopyFile() throws Exception{
        System.out.println("使用字符流缓冲区读取文件...");
        File file = new File("/Users/nuri/Documents/TestFile/ReadFile.txt");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 创建字符流缓冲区 入参为inputStreamReader
        BufferedReader reader = new BufferedReader(inputStreamReader);

        File file1 = new File("/Users/nuri/Documents/TestFile/ReadFile-copy.txt");
        FileOutputStream outputStream = new FileOutputStream(file1);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        // 创建字符流缓冲区 入参为outputStreamWrite
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String line = null;
        while (( line = reader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        reader.close();
        bufferedWriter.close();
    }

    /**
     * 一次性读取文件
     *
     * @throws Exception
     */
    static void useFileReaderCopyFile() throws Exception{
        FileReader fileReader = new FileReader("/Users/nuri/Documents/TestFile/ReadFile.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("/Users/nuri/Documents/TestFile/ReadFile-copy2.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = null;
        while ((line = reader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        reader.close();
        bufferedWriter.close();
    }
}
