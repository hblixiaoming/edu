package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * ÖÐ¹úÃæ·Û
 * Created by LXM on 2016/8/26.
 */
public class ChinaFlour implements Flour {
    String name="China flour";

    @Override
    public String getName() {
        return this.name;
    }
}
