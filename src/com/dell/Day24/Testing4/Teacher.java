package com.dell.Day24.Testing4;

public class Teacher implements Salary {
    private String name;
    private int salary;

    public Teacher(String name) {
        this.name = name;
    }
    @Override
    public int getSalary() {
        salary+=3000;
        System.out.printf("教师%s得到工资%d元\n",this.name,this.salary);
        return salary;
    }
}
