package com.com.hello_rw;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//我的一些操作
public class MyOpt {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    //我要读数据辣
    public void read() {
      readLock.lock();
        System.out.println("[" + Thread.currentThread().getName() + "] 读取数据");

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] 读取完毕");
      readLock.unlock();
    }

    public void write(){
       writeLock.lock();
        System.out.println("["+Thread.currentThread().getName()+"] 写入数据");
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("["+Thread.currentThread().getName()+"] 写入完毕");
        writeLock.unlock();
    }
}
