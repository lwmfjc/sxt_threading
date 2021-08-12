package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//在售票大厅抢票
class Person implements Runnable {
    private final TicketHall ticketHall;
    private Lock lock = new ReentrantLock();

    public Person(TicketHall ticketHall) {
        this.ticketHall = ticketHall;
    }

    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketHall.getNum() > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[" + Thread.currentThread().getName() + "]得到了票[" + ticketHall.getNum() + "]");
                    ticketHall.poolNum(1);
                } else {
                    System.out.println("没票了");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

class TicketHall {
    private int num = 100;

    public int getNum() {
        return num;
    }

    public void poolNum(int num) {
        this.num -= num;
    }
}

public class Main {
    public static void main(String[] args) {
        TicketHall ticketHall = new TicketHall();
        Runnable runnable = new Person(ticketHall);
        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        thread1.start();
        thread2.start();
    }
}
