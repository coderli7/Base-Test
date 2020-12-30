package com.lxl.io;/**
 * Description:
 *
 * @author Administrator
 * @date 2020/9/5 11:28
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * ClassName NIO_Demo
 *
 * @Author Administrator
 * @Date 2020/9/5  11:28
 * Version 1.0
 **/
public class NIO_Demo {

    public static void main(String[] args) {

        //1.write
        // writeNIO();

        // 2.read
        readNIO();

    }


    static void writeNIO() {

        String fileName = "out.txt";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(fileName));
            FileChannel channel = outputStream.getChannel();

            System.out.println(channel);


            ByteBuffer src = Charset.forName("utf8").encode("ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国ddd中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国中华人民共和国");

            System.out.println(src.capacity());
            System.out.println(src.limit());
            int wrLength = 0;


            while ((wrLength = channel.write(src)) != 0) {
                System.out.println("写入长度:" + wrLength);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    static void readNIO() {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("out.txt"));
            FileChannel channel = inputStream.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(10);
            int readLength = -1;
            while ((readLength = channel.read(bf)) != -1) {
                bf.clear();
                byte[] array = bf.array();
                System.out.write(array, 0, readLength);
                System.out.println();
                System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity()
                        + "位置是：" + bf.position());
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
