package fife;

class Thread1 extends Thread {
    @Override
    public void run() {
        int i = 0;
        //在线程1里面启动了线程2
        Thread2 thread2 = new Thread2();
        thread2.setDaemon(true);
        thread2.setName("在线程1内部运行");
        thread2.start();
        while (i++ <= 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]" + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i++ <= 10000) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]" + i);
        }
    }
}

public class LyTest2 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.setName("线程1");
        thread1.start();

        int i = 0;
        while (i++ <= 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[主线程]" + i);
        }
    }
}
