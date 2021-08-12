package com.com.hello2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new CycleThread();
        t.start();
        int i = 0;
        while (i <= 1000) {
            System.out.println("主线程" + i);
            i++;
        }
        //这里让出cpu执行权5ms
        Thread.currentThread().sleep(5);
        t.interrupt();


    }
}
