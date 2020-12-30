package com.lxl.io;/**
 * Description:
 *
 * @author Administrator
 * @date 2020/9/5 10:03
 */

import com.lxl.model.User;
import org.apache.poi.util.IOUtils;
import org.aspectj.util.FileUtil;

import java.io.*;

/**
 * ClassName BIO_Demo
 *
 * @Author Administrator
 * @Date 2020/9/5  10:03
 * Version 1.0
 **/
public class BIO_Demo {


    public static void main(String[] args) {
        User user = new User();
        user.setName("lucy");
        user.setAge(20);
        System.out.println(user);
        writeObjTOFile(user);


        readFileToObj();

    }

    static void writeObjTOFile(Object object) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("tempFile"));
            outputStream.writeObject(object);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }


    static void readFileToObj() {

        ObjectInputStream inputStream = null;
        File file = new File("tempFile");
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            User o = (User) inputStream.readObject();
            System.out.println(o.getName());
            System.out.println(o.getAge());

            // User user = (User) inputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);

            try {
                FileUtil.deleteContents(file);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }


    }


}
