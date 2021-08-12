package com.com.hello1;

/**
 * 小红的任务
 */
public class TaskHong implements Runnable {
    public void run() {
        int i = 1;
        while (i <= 100) {
            System.out.println("["+Thread.currentThread().getName()+"]跑了第" + i + "步");
            i++;
        }
    }
}
