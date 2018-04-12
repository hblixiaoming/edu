package com.lxm.design.pattern.singleton_pattern.pattern2;

/**
 * lazy loading,thread safe,not productive
 * ����д���ܹ��ڶ��߳��кܺõĹ��������ҿ�������Ҳ�߱��ܺõ�lazy loading��
 * ���ǣ��ź����ǣ�Ч�ʺܵͣ�99%����²���Ҫͬ��
 * Created by LXM on 2016/8/26.
 */
public class Singleton {

    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
