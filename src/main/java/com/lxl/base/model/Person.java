package com.lxl.base.model;

import java.util.List;

/**
 * ClassName Person
 *
 * @Author Administrator
 * @Date 2019/12/25  9:48
 * Version 1.0
 **/
public class Person {

    private String name;
    private Integer age;
    private List hobbies;

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

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }
}
