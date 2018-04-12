package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * ������ԭ�Ϲ���
 * Created by LXM on 2016/8/26.
 */
public class AmericaSourceFactory implements SourceFactory{
    @Override
    public Flour createFlour() {
        return new AmericaFlour();
    }

    @Override
    public Meat createMeat() {
        return new ChinaMeat();
    }
}
