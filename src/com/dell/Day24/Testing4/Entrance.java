package com.dell.Day24.Testing4;

public class Entrance {
    public static void main(String[] args) {
        Graduate graduate = new Graduate("李白");
        Teacher teacher = new Teacher("杜甫");
        University newSoft = new University();
        newSoft.payOff(graduate);
        newSoft.payOff(teacher);
        System.out.printf("学费为%d的研究生%s%s贷款\n",graduate.getFee(),graduate.name,
                graduate.isLoan() ? "需要" : "不需要");

    }
}
