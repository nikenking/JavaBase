package com.dell.week3;

import static com.dell.week3.Constant.ComputerName;
import static com.dell.week3.RandomUtil.getRandomNumber;
public class Computer extends GamePlayer {

    private RandomUtil randomUtil;
    //需重写父类方法
    @Override
    public int getInputValue() {
        return getRandomNumber();
    }
    public String getComputerName(){
        return ComputerName[getRandomNumber()];
    }
}
