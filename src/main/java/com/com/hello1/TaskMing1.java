package com.com.hello1;

/**
 * 小明的任务
 */
public class TaskMing1 implements Runnable {

    public void run() {
        Thread.currentThread().setName("小明");
        int i = 1;
        while (i <= 100) {
            System.out.println("[" + Thread.currentThread().getName() + "]跑了第" + i + "步");
            if (i == 50) {
                //小明跑完第50步的时候,停下来等小红跑完
                Thread thread = new Thread(new TaskHong1(), "小红");
                thread.setDaemon(true);
                thread.start();
            }
            i++;
        }
    }
}
