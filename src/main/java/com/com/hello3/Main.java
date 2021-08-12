package com.com.hello3;
//通过改变一个entity的属性来模拟生产
public class Main {
    public static void main(String[] args) {
        Product product=new Product();

        new Thread(new Producer(product),"狗东").start();
        new Thread(new Consumer(product),"上帝").start();
    }

}
