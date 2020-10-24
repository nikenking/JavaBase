package com.dell.Day19;

public class Panda {
    int wight;
    String sex;

    public Panda(int wight, String sex) {
        this.wight = wight;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Panda{" +
                "wight=" + wight +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Panda panda = (Panda) o;
        return wight == panda.wight &&
                sex.equals(panda.sex);
    }

//    public boolean equals(Panda panda){
//        if (this==panda){
//            return true;
//        }else {
//            if (this.sex==panda.sex&&this.wight==panda.wight){
//                return true;
//            }
//            return false;
//        }
//    }
}
