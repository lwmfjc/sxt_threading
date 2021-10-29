package fife.communicate.method2;

import fife.communicate.Apple;
import fife.communicate.Banana;
import fife.communicate.Fruit;
import fife.communicate.Stock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 任务：生产一个水果
 */
public class Producer implements Runnable {
    private Object oLock;
    private Condition conditionProducer;
    private Condition conditionConsumer;
    private ReentrantLock reentrantLock;

    public Producer(Object o, ReentrantLock reentrantLock, Condition conditionProducer, Condition conditionConsumer) {
        this.oLock = o;
        this.conditionConsumer = conditionConsumer;
        this.conditionProducer = conditionProducer;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            while (Stock.stock.isFull()) {
                try {
                    conditionProducer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean isEven = new Random().nextInt(10) % 2 == 0;
            Fruit fruit = isEven ? new Apple("苹果", 5) :
                    new Banana("香蕉", 6);
            Stock.stock.putFruit(fruit);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产了" + fruit);
            conditionConsumer.signalAll();

            reentrantLock.unlock();
        }
    }
}
