package fife.communicate.method1;

public class Main {
    public static void main(String[] args) {
        Object oLock=new Object();
        Producer producer = new Producer(oLock);
        Consumer consumer = new Consumer(oLock);

        Thread thread1 = new Thread(producer);
        thread1.start();

        Thread thread2 = new Thread(consumer);
        thread2.start();
    }
}
