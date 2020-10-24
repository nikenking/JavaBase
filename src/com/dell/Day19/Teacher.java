package com.dell.Day19;

import java.util.Objects;

public class Teacher {
    int age;
    String name;

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age &&
                name.equals(teacher.name);
    }
}
