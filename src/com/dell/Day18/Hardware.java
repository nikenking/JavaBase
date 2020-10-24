package com.dell.Day18;

public class Hardware extends Maintainer {
    public Hardware(int id,String name) {
        setId(id);
        setName(name);
        setType("Hardware");
    }

    @Override
    public void work() {
        super.work();
        System.out.println("正在修复打印机");
    }
}
