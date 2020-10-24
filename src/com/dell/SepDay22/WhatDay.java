package com.dell.SepDay22;

import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WhatDay {
    @Test
    public void test(/**/)throws IOException, InterruptedException{
        LocalDateTime ld = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDate ldt = LocalDate.of(2020,9,23);
        System.out.println(ldt.plusDays((28800 - 19178)/25));
    /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse("1990-01-01 00:00:00", dtf);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(start, now);
        if (duration.toDays() % 5 < 3) {
            System.out.println("打鱼");
        } else System.out.println("晒网");*/
    }
}
