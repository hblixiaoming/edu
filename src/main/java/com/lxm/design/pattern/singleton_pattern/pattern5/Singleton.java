package com.lxm.design.pattern.singleton_pattern.pattern5;

/**
 * Ë«ÖØ¼ì²éËø
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
