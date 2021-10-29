package fife.communicate.method1;

import fife.communicate.Stock;

/**
 * 任务 消费一个水果
 */
public class Consumer implements Runnable{

    private Object oLock;
    public Consumer(Object o) {
        oLock=o;
    }
    @Override
    public void run() {
        while (true) {

            synchronized (oLock) {

                while (Stock.stock.isEmpty()){
                    try {
                        oLock.wait();
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

                oLock.notify();
            }
        }
    }
}
