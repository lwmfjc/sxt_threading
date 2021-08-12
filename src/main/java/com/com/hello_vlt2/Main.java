package com.com.hello_vlt2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger i=new AtomicInteger();

    public static void main(String[] args) {
        for (int j = 0; j < 100000; j++) {
            new Thread(()->{
                i.incrementAndGet();
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
