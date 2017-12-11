package com.macro.cloud.bean;

/**
 * Created by zhenghong on 2017/12/8.
 */
public class User {
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

    @Override
    public String toString() {
        return "[name="+name+",age="+age+"]";
    }
}
