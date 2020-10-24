package com.dell.Day26;

public class MyNagativeException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;//唯一标识

    public MyNagativeException() {
    }

    public MyNagativeException(String message) {
        super(message);
    }
}
