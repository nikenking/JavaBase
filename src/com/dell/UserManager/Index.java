package com.dell.UserManager;

import com.dell.UserManager.Dao.Manager;
import com.dell.UserManager.Dao.User;
import com.dell.UserManager.Util.Tools;
import com.dell.UserManager.View.Viewer;
//许珊珊 许盈盈 何方晴 苏依依 楚晓瑶 叶韵竹 宁欣儿 苏梦欣
public class Index {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Viewer viewer = new Viewer();
        viewer.showPage(manager);
    }
}
