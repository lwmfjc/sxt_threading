package fife.communicate.method2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Object oLock=new Object();
        ReentrantLock reentrantLock=new ReentrantLock();
        //生产者的锁和消费者的锁
        Condition conditionProducer=reentrantLock.newCondition();
        Condition conditionConsumer=reentrantLock.newCondition();

        Producer producer = new Producer(oLock,reentrantLock,conditionProducer,conditionConsumer);
        Consumer consumer = new Consumer(oLock,reentrantLock,conditionProducer,conditionConsumer);

        Thread thread1 = new Thread(producer);
        thread1.start();

        Thread thread2 = new Thread(consumer);
        thread2.start();
    }
}
