package com.dell.UserManager.Service;

import com.dell.UserManager.Dao.User;
import com.dell.UserManager.Util.Tools;

import java.util.Scanner;

public class UserService {
    int total;
    Tools t = new Tools();
    User[] users;
    Scanner scanner = new Scanner(System.in);

    public UserService(int total,User[] users){
        this.total = total;
        this.users = new User[total];
        for (User u:users){
            addUser(u);
        }
    }

    public String getUserList(){
        String info="-------------------------------用户列表-------------------------------------\n";
        for (User i:users){
            if (i!=null){
                info+=i.toString()+"\n";}
        }
        return info;
    }

    public boolean addUser(User user){//自动添加
        for (int j = 0; j < total; j++) {
            if (this.users[j]==null){
                this.users[j] = user;
                this.users[j].setId(j);
                return true;
            }
        }
        return false;
    }

    public boolean addUser(){//手动添加
        System.out.println("请输入姓名：");
        String name = scanner.next();
        if(!t.nameCheck(name))return false;
        System.out.println("请输入性别：");
        String gender = scanner.next();
        if (!t.genderCheck(gender))return false;
        System.out.println("请输入年龄：");
        String age = scanner.next();
        if(!t.ageCheck(age))return false;
        System.out.println("请输入电话：");
        String phone = scanner.next();
        if(!t.telCheck(phone))return false;
        System.out.println("请输入邮件：");
        String email = scanner.next();
        if(!t.emailCheck(email))return false;
        User _user = new User(name,gender,Integer.parseInt(age),phone,email);
        if (addUser(_user)){
            return true;
        };
        return false;
    }

    public boolean deleteUser(int id){
        for (int i = 0; i < total; i++) {
            if (i==id){
                this.users[i] = null;
                return true;
            }
        }
        return false;
    }

    public void updataUser(){
        System.out.print("输入要修改的序号:");
        String  id = scanner.next();
        if (!t.numCheck(id)){
            return;
        }
        if(this.users[Integer.parseInt(id)]==null){
            System.out.println("无此用户");
            return;
        }
        System.out.println("输入新的姓名:");
        String name = scanner.next();
        if(!t.nameCheck(name)){
            System.out.println("用户名格式有误，请重试");
            return;
        }
        System.out.println("输入新的性别:");
        String gender = scanner.next();
        if (!t.genderCheck(gender)){
            System.out.println("性别格式有误，请重试");
            return;
        }
        System.out.println("输入新的年龄:");
        String age = scanner.next();
        if(!t.ageCheck(age)){
            System.out.println("年龄格式有误，请重试");
            return;
        }
        System.out.println("输入新的电话:");
        String phone = scanner.next();
        if (!t.telCheck(phone)){
            System.out.println("电话格式有误，请重试");
            return;
        }
        System.out.println("输入新的email:");
        String email = scanner.next();
        if (!t.emailCheck(email)){
            System.out.println("邮箱格式有误，请重试");
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (i==Integer.parseInt(id)){
                users[i].setName(name);
                users[i].setGender(gender);
                users[i].setAge(Integer.parseInt(age));
                users[i].setPhone(phone);
                users[i].setEmail(email);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("无此用户");
    }

    public void searchId(int id){
        for (int i = 0; i < users.length; i++) {
            if (i==id&&users[i]!=null){
                System.out.println(users[i].toString());
                return;
            }
        }
        System.out.println("无此用户");
    }
}
