package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * 原料生产工厂
 * Created by LXM on 2016/8/26.
 */
public interface SourceFactory {
    Flour createFlour();
    Meat createMeat();
}
