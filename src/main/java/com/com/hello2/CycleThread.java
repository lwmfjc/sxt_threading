package com.com.hello2;

public class CycleThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(++i);
        }
    }
}
