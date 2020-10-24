package com.dell.UserManager.Dao;

public class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String email;

    public User(String name, String gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "用户"+name+"的信息为{" +
                "id=" + id +
                ", 姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age +
                ", 电话='" + phone + '\'' +
                ", 邮箱='" + email + '\'' +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
