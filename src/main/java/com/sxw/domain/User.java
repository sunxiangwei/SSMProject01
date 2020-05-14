package com.sxw.domain;

import java.io.Serializable;

/**
 * Created by Sunxiangwei on 2020-5-1.
 */
public class User implements Serializable {

    private Integer uno;
    private String uname;
    private String upass;
    private Integer age;

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer uno, String uname, String upass, Integer age) {
        this.uno = uno;
        this.uname = uname;
        this.upass = upass;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uno=" + uno +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", age=" + age +
                '}';
    }
}
