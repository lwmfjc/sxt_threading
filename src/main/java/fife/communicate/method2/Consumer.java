package fife.communicate.method2;

import fife.communicate.Stock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 任务 消费一个水果
 */
public class Consumer implements Runnable{


    private Object oLock;
    private  Condition conditionProducer;
    private Condition conditionConsumer;
    private ReentrantLock reentrantLock;
    public Consumer(Object o, ReentrantLock reentrantLock, Condition conditionProducer, Condition conditionConsumer) {
        this. oLock=o;
        this.conditionConsumer=conditionConsumer;
        this.conditionProducer=conditionProducer;
        this.reentrantLock=reentrantLock;
    }
    @Override
    public void run() {
        while (true) {

            reentrantLock.lock();

                while (Stock.stock.isEmpty()){
                    try {
                        //oLock.wait();
                        conditionConsumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费了一个水果"+Stock.stock.getFruit());

                conditionProducer.signalAll();

            reentrantLock.unlock();
        }
    }
}
