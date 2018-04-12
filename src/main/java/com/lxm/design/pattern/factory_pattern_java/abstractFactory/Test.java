package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * ≤‚ ‘¿‡
 * Created by LXM on 2016/8/26.
 */
public class Test {
    public static void main(String[] args){
        SourceFactory sourceFactory=new ChinaSoureFactory();
        PizzaStore store=new BeiJingPizzaStore(sourceFactory);

        Pizza pizza=store.orderPizza("apple");
        System.out.println(pizza.meat.getName());
        System.out.println(pizza.flour.getName());
    }
}
