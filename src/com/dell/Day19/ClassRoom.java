package com.dell.Day19;

import java.util.Objects;

public class ClassRoom {
    @Override
    public String toString() {
        return "ClassRoom{" +
                "number=" + number +
                ", area=" + area +
                ", teacher=" + teacher.toString() +
                '}';
    }

    int number;
    double area;
    Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return number == classRoom.number &&
                Double.compare(classRoom.area, area) == 0 &&
                teacher.equals(((ClassRoom) o).teacher);
    }

    public ClassRoom(int number, double area, Teacher teacher) {
        this.number = number;
        this.area = area;
        this.teacher = teacher;
    }
}
