package com.lxl.arrandcol;

import java.util.LinkedList;

/**
 * ClassName Demo1
 *
 * @Author Administrator
 * @Date 2019/12/25  10:19
 * Version 1.0
 **/
public class Demo1 {

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add("g");
        linkedList.add("i");
        linkedList.add("i");
        linkedList.add("i");
        linkedList.add("i");
        Object a = linkedList.get(0);
        linkedList.remove(2);
        System.out.println(a);
        System.out.println(linkedList);
    }
}
