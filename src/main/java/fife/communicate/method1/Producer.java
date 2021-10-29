package fife.communicate.method1;

import fife.communicate.Apple;
import fife.communicate.Banana;
import fife.communicate.Fruit;
import fife.communicate.Stock;

import java.util.Random;

/**
 * 任务：生产一个水果
 */
public class Producer implements Runnable {
    private Object oLock;
    public Producer(Object o) {
        oLock=o;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (oLock) {

                while (Stock.stock.isFull()){
                    try {
                        oLock.wait();
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
                System.out.println("生产了"+fruit);
                oLock.notifyAll();
            }
        }
    }
}
