package com.lxm.concurrent;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static int addMonth(int currentTime, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(currentTime * 1000L));
        calendar.add(Calendar.MONTH, month);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static void main(String[] args) {
        int time = addMonth((int) (System.currentTimeMillis() / 1000), 6);
        System.out.println(time);
    }
}
