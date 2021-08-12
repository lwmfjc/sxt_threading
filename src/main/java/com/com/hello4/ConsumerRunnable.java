package com.com.hello4;

public class ConsumerRunnable implements Runnable {
    private Supermarket supermarket;

    public ConsumerRunnable(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
    @Override
    public void run() {
        supermarket.consumer();
    }
}
