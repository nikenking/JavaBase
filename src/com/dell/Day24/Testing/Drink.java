package com.dell.Day24.Testing;

abstract class Drink {
    public abstract void taste();
    public static Drink getDrink(int type){
        switch (type){
            case 1:
                return new Coffee();
            case 2:
                return new Beer();
            default:return new Milk();
        }
    }
}
