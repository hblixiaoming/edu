package com.lxm.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCompute {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("1", 1));
        apples.add(new Apple("2", 1));
        apples.add(new Apple("3", 1));
        apples.add(new Apple("4", 1));
        apples.add(new Apple("5", 2));
        apples.add(new Apple("6", 2));
        apples.add(new Apple("7", 2));
        Map<Integer, Integer> map = new HashMap<>();
        apples.forEach(e -> {
            map.compute(e.getColor(), (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        });
        System.out.println(map);
    }
}
