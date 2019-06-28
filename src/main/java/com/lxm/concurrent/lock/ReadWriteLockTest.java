package com.lxm.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by LXM on 2019/6/17.
 */
public class ReadWriteLockTest {

    private ReentrantReadWriteLock rwLock;

    public ReadWriteLockTest() {
        this.rwLock = new ReentrantReadWriteLock();
    }

    public void testReadLock() {
        rwLock.readLock().lock();
        try {

        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void testWriteLock() {
        rwLock.writeLock().lock();
        try {

        } finally {
            rwLock.writeLock().unlock();
        }
    }


}
