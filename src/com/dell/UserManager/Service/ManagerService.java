package com.dell.UserManager.Service;

import com.dell.UserManager.Dao.Manager;

import java.util.Scanner;

public class ManagerService {
    public boolean Logout(Manager manager){
        manager.setLog(false);
        return true;
    }
    public boolean Login(Manager[] managers){
        Scanner scanner = new Scanner(System.in);
        String uname;
        String upass;
        System.out.println("当前无管理员账号登录，请登录后使用*********");
        System.out.print("请输入管理员账户:");
        uname = scanner.nextLine();
        System.out.print("请输入管理员密码:");
        upass = scanner.nextLine();
        for (Manager manager:managers){
            if (manager!=null){
                if (manager.getUname().equals(uname)&&manager.getUpass().equals(upass)==false){
                    System.out.print("密码出错,请重试\n");
                    return false;
                }else if (manager.getUname().equals(uname)&&manager.getUpass().equals(upass)){
                    System.out.print("登录成功，欢迎您 "+manager.getUname()+"\n");
                    manager.setLog(true);
                    return true;
                }
            }
        }
        System.out.println("无此用户.");
        return false;
    }
}
