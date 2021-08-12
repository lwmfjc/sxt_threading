package com.com.hello4;

public class ProducerRunnable implements Runnable {
    private Supermarket supermarket;

    public ProducerRunnable(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    @Override
    public void run() {
        supermarket.product();
    }
}
