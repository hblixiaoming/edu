package com.lxm.pcquestion;

public interface Container<T> {
    void put(T t);

    T take();
}
