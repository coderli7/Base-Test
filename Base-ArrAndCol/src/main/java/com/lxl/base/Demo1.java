package com.lxl.base;/**
 * Description:
 *
 * @author Administrator
 * @date 2020/7/29 16:06
 */

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName Demo1
 *
 * @Author Administrator
 * @Date 2020/7/29  16:06
 * Version 1.0
 **/
public class Demo1 {

    public static void main(String[] args) {


        String[] arr = {"1", "2"};

        String obj = StringUtils.join(arr, '-');

        System.out.println(obj);


    }


}
