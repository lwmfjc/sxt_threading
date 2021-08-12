package com.com.hello4;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Supermarket supermarket = new Supermarket(product);
        ProducerRunnable producer = new ProducerRunnable(supermarket);
        ConsumerRunnable consumer = new ConsumerRunnable(supermarket);
        //启动消费者和生产者线程
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
