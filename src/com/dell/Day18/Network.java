package com.dell.Day18;

public class Network extends Maintainer{
    public Network(int id,String name) {
        setId(id);
        setName(name);
        setType("Network");
    }
    @Override
    public void work() {
        super.work();
        System.out.println("正在检测网络是否畅通");
    }
}
