package fife;
class MyRun implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (++i <= 1000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("["+Thread.currentThread().getName()+"]"+i);
            if(i==50){
                Thread thread4=new Thread(new MyTask());
                thread4.setName("之中插入");
                thread4.start();
                try {
                    thread4.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyTask implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (++i <= 1000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("["+Thread.currentThread().getName()+"]"+i);
        }
    }
}

public class LyTest {
    public static void main(String[] args) throws InterruptedException {
        MyTask task1=new MyTask();

        MyTask task2=new MyTask();
        MyRun myRun=new MyRun();

        Thread thread1=new Thread(task1);
        thread1.setName("线程1");
        thread1.start();
        Thread thread2=new Thread(task2);
        thread2.setName("线程2");
        thread2.start();
        Thread thread3=new Thread(myRun);
        thread3.setName("线程3 myrun");
        thread3.start();
        /*int i=0;
        while (++i<=100){
            Thread.sleep(1);
            System.err.println("[main]"+i);
           if(i==50){
                thread1.join();
            }
        }*/

    }
}
