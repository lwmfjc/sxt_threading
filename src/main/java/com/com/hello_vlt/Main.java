package com.com.hello_vlt;

public class Main {

    //使用volatile保证可见性
    volatile static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (flag) {
                    i++;
                }
                System.out.println("结束了");
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }
}
