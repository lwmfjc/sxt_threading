package com.com.hello1;

/**
 * 小红的任务
 */
public class TaskHong1 implements Runnable {
    public void run() {
        int i = 1;
        while (true) {
            System.out.println("["+Thread.currentThread().getName()+"]跑了第" + i + "步");
            i++;
        }
    }
}
