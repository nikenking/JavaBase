package com.dell.Day20;

public class Acount {
    static int id;
    private int accountid;
    private int pass;
    private double blance;
    static float rate = 0.02f;
    static int minBalance = 0;

    public Acount(String pass, String blance) {
        this.pass = Integer.parseInt(pass);
        this.blance = (double)Integer.parseInt(blance);
        this.accountid = ++id;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + accountid +
                ", pass=" + pass +
                ", blance=" + blance +
                ",minBalance=" + minBalance+
                ",rate=" + rate+
                '}';
    }
}
