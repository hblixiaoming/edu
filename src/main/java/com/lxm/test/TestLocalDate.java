package com.lxm.test;

import java.time.LocalDate;

public class TestLocalDate {

    public void test() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusMonths(1);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
    }

    public static void main(String[] args) {
        TestLocalDate test = new TestLocalDate();
        test.test();
    }
}
