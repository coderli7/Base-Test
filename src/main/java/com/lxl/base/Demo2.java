package com.lxl.base;


import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Demo2
 *
 * @Author Administrator
 * @Date 2019/12/17  13:38
 * Version 1.0
 **/
public class Demo2 {


    public static void main(String[] args) {


        Map map = new HashMap();

        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");


        Object o = map.get("2");

        System.out.println(o);

    }
}


