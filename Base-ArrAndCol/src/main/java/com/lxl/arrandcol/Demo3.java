package com.lxl.arrandcol;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName Demo3
 *
 * @Author Administrator
 * @Date 2020/3/2  14:34
 * Version 1.0
 **/
public class Demo3 {


    public static void main(String[] args) {


        String str1 = "";
        String str2 = " ";
        String str3 = null;
        String str4 = "dd dd";
        //System.out.println(StringUtils.isEmpty(str1));
        //System.out.println(StringUtils.isEmpty(str2));
        //System.out.println(StringUtils.isEmpty(str3));
        //System.out.println(StringUtils.isEmpty(str4))
        //System.out.println(StringUtils.isBlank(str1));
        //System.out.println(StringUtils.isBlank(str2));
        //System.out.println(StringUtils.isBlank(str3));
        //System.out.println(StringUtils.isBlank(str4));
        //System.out.println(StringUtils.isBlank(str4));
        System.out.println(StringUtils.isAnyBlank(str4));



        //System.out.println(StringUtils.isEmpty(str4));


    }


}
