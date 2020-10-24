package com.dell.Day18;

public class Android extends Developer {
    public Android(int id,String name) {
        setId(id);
        setName(name);
        setType("Android");
    }
    @Override
    public void work() {
        super.work();
        System.out.println("正在研发淘宝手机端app");
    }
}
