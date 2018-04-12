package com.lxm.design.pattern.singleton_pattern.pattern4;

/**
 *
 *  �����Ͽ��������ͦ����ʵ�������ַ�ʽ��࣬���������ʼ����ʵ����instance��
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static Singleton instance = null;
    static {
        instance = new Singleton();
    }
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }

}
