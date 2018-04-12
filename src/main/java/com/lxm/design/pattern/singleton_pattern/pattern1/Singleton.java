package com.lxm.design.pattern.singleton_pattern.pattern1;

/**
 * ��һ�ֵ����࣬
 *
 * lazy loading,not thread safe
 * ����д��lazy loading�����ԣ��������������ڶ��̲߳�������������
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
