package com.dell.Day17;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
如果父类方法的返回值是引用数据类型，那么子类返回的值只能该引用类型或其子类
 */
public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        a1.show(d);
    }
}
