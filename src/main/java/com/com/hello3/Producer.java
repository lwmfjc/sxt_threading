package com.com.hello3;

import java.util.concurrent.TimeUnit;

//生产者
public class Producer implements Runnable {
    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    public void run() {
        int i = 0;
        while (true) {
            //不断生产产品(这里是用不断改变产品属性进行模拟)
            //生产过程中不允许消费
            synchronized (product) {
                if (product.isProduced()) {
                    try {
                        //进入等待队列
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    product.setName("拖鞋");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setPrice(10);
                } else {
                    product.setName("皮鞋");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setPrice(248);
                }
                System.out.printf("[" + Thread.currentThread().getName()
                                + "]生产了%s %d一双\n", product.getName()
                        , product.getPrice());
                i++;

                product.setProduced(true);
                //告诉消费者,你可以消费了
                product.notifyAll();
            }
        }
    }
}
