package com.lxl.base;


import sun.misc.Launcher;

import java.net.URL;

/**
 * ClassName Demo2
 *
 * @Author Administrator
 * @Date 2019/12/17  13:38
 * Version 1.0
 **/
public class Demo2 {


    public static void main(String[] args) {

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        for (URL url:
             urLs) {
            System.out.println(url.toExternalForm());
        }
        //Class<Demo2> demo2Class = Demo2.class;
        //
        //ClassLoader classLoader1 = demo2Class.getClassLoader();
        //
        //ClassLoader classLoader1Parent = classLoader1.getParent();
        //
        //ClassLoader classLoader1ParentParent = classLoader1Parent.getParent();
        //
        //
        //
        //System.out.println(classLoader1.toString());
        //System.out.println(classLoader1Parent.toString());
        //System.out.println(classLoader1ParentParent);
    }
}


