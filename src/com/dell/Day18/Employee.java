package com.dell.Day18;

public class Employee {
    private int id;
    private String name;
    private String type;
    public Employee() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void work(){
        System.out.print("员工号为"+this.id+"的"+type+"员工"+this.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
