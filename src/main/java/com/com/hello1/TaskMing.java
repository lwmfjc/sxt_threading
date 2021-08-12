package com.com.hello1;

/**
 * 小明的任务
 */
public class TaskMing implements Runnable {

    public void run() {
        //Thread.currentThread().setDaemon(true);
        int i = 1;
        while (i <= 100) {
            System.out.println("[" + Thread.currentThread().getName() + "]跑了第" + i + "步");
            if (i == 50) {
                //小明跑完第50步的时候,停下来等小红跑完
                Thread thread = new Thread(new TaskHong(), "小红");
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }
}
