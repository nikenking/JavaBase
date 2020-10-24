package com.dell.Day18;

public class Manager {
    private  Employee[] employee;

    public Manager(Employee[] employee) {
        this.employee = employee;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public void showWork(){
        for (Employee e:employee){
            e.work();
        }
    }
}
