package com.dell.UserManager.Dao;

public class Manager {
    private String uname;
    private String upass;
    private boolean log;

    public Manager() {
        this.uname = "admin";
        this.upass = "admin";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }
}
