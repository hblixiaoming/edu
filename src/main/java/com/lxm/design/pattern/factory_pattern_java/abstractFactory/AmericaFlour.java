package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * �������
 * Created by LXM on 2016/8/26.
 */
public class AmericaFlour implements Flour {

    String name="America flour";
    @Override
    public String getName() {
        return this.name;
    }
}
