package com.dell.Day24.Testing4;

public class Graduate extends Student implements Salary {
    int salary;

    public Graduate(String name) {
        super(name);
        setFee(2000);
    }

    @Override
    public int getSalary() {//得到工资
        salary+=1500;
        System.out.printf("研究生%s得到工资%d元\n",this.name,this.salary);
        return salary;
    }

    @Override
    int getFee() {//返回学分
        return this.fee;
    }

    @Override
    void setFee(int fee) {//设置学费
        this.fee+=fee;
    }

    public boolean isLoan(){//返回是否需要贷款
        return this.fee > this.salary;
    }


}
