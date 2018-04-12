package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

/**
 * �й���ԭ�Ϲ���
 * Created by LXM on 2016/8/26.
 */
public class ChinaSoureFactory implements SourceFactory{
    @Override
    public Flour createFlour() {
        return new ChinaFlour();
    }

    @Override
    public Meat createMeat() {
        return new ChinaMeat();
    }
}
