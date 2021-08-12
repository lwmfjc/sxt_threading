package com.com.hello4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Supermarket implements Runnable {
    private Product product;
    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();
    private boolean hasProduct = false;//工厂里面有产品

    public Supermarket(Product product) {
        this.product = product;
    }

    public void product() {
        int i = 0;
        //我要一直生产
        while (true) {
            lock.lock();
            try {
                while (this.hasProduct) {
                    try {
                        producer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product.setName(i % 2 == 0 ? "苹果20" : "香蕉10");
                //模拟线程切换
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setPrice(i % 2 == 0 ? 20 : 10);
                System.out.println("生产了[" + product + "]");
                i++;
                this.hasProduct=true;
                //生产完通知消费者消费
                consumer.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    //进行消费
    public void consumer() {
        while (true) {
            lock.lock();
            try {
                //没有商品就一直等待
                while (!this.hasProduct) {
                    try {
                        consumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费了[" + product + "]");
                this.hasProduct=false;
                producer.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        product();
        consumer();
    }
}
