package com.com.hello3;

//消费者
public class Consumer implements Runnable {
    private final Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    public void run() {
        while (true) {
            synchronized (product) {
                //为什么是while,因为要不停的试探是不是可以消费
                //如果没有生产(线程)就进入等待队列
                while (!product.isProduced()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("["+Thread.currentThread().getName()
                        +"]买了一双%s %d/双\n", product.getName(),
                        product.getPrice());
                //告诉消费者，我消费完了 你继续制造
                product.setProduced(false);
                product.notifyAll();
            }
        }
    }
}
