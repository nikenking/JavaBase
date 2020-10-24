package com.dell.Day18;

public class JavaEE extends Developer {
    public JavaEE(int id,String name) {
        setId(id);
        setName(name);
        setType("JavaEE");
    }

    @Override
    public void work() {
        super.work();
        System.out.println("正在研发淘宝网站");
    }
}
