package com.lxl.io;/**
 * Description:
 *
 * @author Administrator
 * @date 2020/9/5 14:49
 */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * ClassName AIO_Demo
 *
 * @Author Administrator
 * @Date 2020/9/5  14:49
 * Version 1.0
 **/
public class AIO_Demo {


    public static void main(String[] args) {

        // writeAIO();
        readAIO();
    }


    static void writeAIO() {

        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("out.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {

                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("Attachment:********************* " + attachment + " " + result
                            + " bytes written");
                    System.out.println("CompletionHandler Thread ID:********************* "
                            + Thread.currentThread().getId());
                }

                @Override
                public void failed(Throwable e, Object attachment) {
                    System.err.println("Attachment: " + attachment + " failed with:");
                    e.printStackTrace();
                }
            };

            System.out.println("Main Thread ID: " + Thread.currentThread().getId());


            fileChannel.write(ByteBuffer.wrap("AAAAAAA".getBytes()), 0, "First Write",
                    handler);

            Thread.sleep(2000);
            // fileChannel.write(ByteBuffer.wrap("BBBBBBB".getBytes()), 0, "Second Write",
            //         handler);

            System.out.println("Main Thread ID: " + "END!!!");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    static void readAIO() {


        Path file = Paths.get("out.txt");
        AsynchronousFileChannel channel = null;
        try {
            channel = AsynchronousFileChannel.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {

            System.out.println("Read  NOT  OK!!!");

        }
        Integer bytesRead = null;
        try {
            bytesRead = result.get();

            System.out.println(new String(buffer.array(), 0, bytesRead));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Bytes read [" + bytesRead + "]");
    }


}


