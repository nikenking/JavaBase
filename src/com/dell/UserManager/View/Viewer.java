package com.dell.UserManager.View;

import com.dell.UserManager.Dao.Manager;
import com.dell.UserManager.Dao.User;
import com.dell.UserManager.Service.ManagerService;
import com.dell.UserManager.Service.UserService;
import com.dell.UserManager.Util.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Viewer {
    public void showPage(Manager manager){
        Manager[] mlist = {manager};
        Tools t = new Tools();
        ManagerService managerservice = new ManagerService();//用户管理类
        User[] ulist = {new User("Nike","M",19,"15756217611","15756217611"),
                new User("Gabe","M",19,"15756217611","15756217611"),
                new User("Lina","M",20,"15756217611","15756217611"),
                new User("Rien","M",33,"15756217611","15756217611"),
                new User("Lucy","F",16,"15756217611","15756217611")};
        UserService userService = new UserService(10,ulist);//添加所有的user
        String operation;
        Date day=new Date();
        int overlogging = 0;
        while (true){
            if (manager.isLog()){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.printf("-----------欢迎来到CY用户管理系统------------------\n");
                System.out.printf("--------当前时间:"+df.format(day)+"---------------");
                System.out.printf("\n1.用户列表\n2.新增用户\n3.删除用户\n4.修改用户\n5.查找用户\n6.退出\n");
                System.out.printf("----------当前管理员:"+manager.getUname()+"-------------------\n");
                System.out.print("请输入需要的操作序号:");
                operation = new Scanner(System.in).next();
                switch (operation){
                    case "1":
                        System.out.println(userService.getUserList());
                        break;
                    case "2":
                        System.out.println("用户添加"+(userService.addUser()?"成功":"失败,格式有误,请检查后重试"));
                        break;
                    case "3":
                        System.out.print("请输入要删除的序号:");
                        String id = new Scanner(System.in).next();
                        System.out.printf("是否确定删除？确定输入Y:");
                        String ifDoit = new Scanner(System.in).next();
                        if (t.numCheck(id)&&("Y".equals(ifDoit)||"y".equals(ifDoit))){
                            System.out.println("用户删除"+(userService.deleteUser(Integer.parseInt(id))?"成功":"失败"));
                        }
                        break;
                    case "4":
                        userService.updataUser();
                        break;
                    case "5":
                        System.out.print("请输入要查询的用户id:");
                        String searchId = new Scanner(System.in).next();
                        if (t.numCheck(searchId)){
                            userService.searchId(Integer.parseInt(searchId));
                            break;
                        }else break;
                    case "6":
                        managerservice.Logout(mlist[0]);
                        System.out.println("管理员退出...");
                        break;
                    default:
                        System.out.println("无效操作符，请重新输入");
                        break;
                }
            }else{
                if (overlogging<5){
                    overlogging++;
                    managerservice.Login(mlist);
                }else{
                    System.out.printf("登陆次数过多");
                    break;
                }
            }
        }
    }
}