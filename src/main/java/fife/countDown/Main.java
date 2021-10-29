package fife.countDown;

import javax.swing.plaf.IconUIResource;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static CountDownLatch countDownLatch=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            Thread.currentThread().setName("线程1");
            int i=200;
            while (i>=101){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---"+i--);
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            Thread.currentThread().setName("线程2");
            int i=100;
            while (i>=0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---"+i--);
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.err.println("主线程执行");
    }
}
