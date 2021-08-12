package com.com.hello4;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Supermarket supermarket = new Supermarket(product);
        ProducerRunnable producer = new ProducerRunnable(supermarket);
        ConsumerRunnable consumer = new ConsumerRunnable(supermarket);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
