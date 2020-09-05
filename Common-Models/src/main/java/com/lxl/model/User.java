package com.lxl.model;/**
 * Description:
 *
 * @author Administrator
 * @date 2020/9/5 10:16
 */


import java.io.Serializable;

/**
 * ClassName User
 *
 * @Author Administrator
 * @Date 2020/9/5  10:16
 * Version 1.0
 **/
public class User   implements Serializable {


    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
