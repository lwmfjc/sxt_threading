package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//在售票大厅抢票
class Person1 implements Runnable {
    private final TicketHall1 ticketHall;
    private Lock lock = new ReentrantLock();

    public Person1(TicketHall1 ticketHall) {
        this.ticketHall = ticketHall;
    }

    public void run() {
        if (ticketHall.getNum() > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]得到了票[" + ticketHall.getNum() + "]");
            ticketHall.poolNum(1);
        } else {
            System.out.println("没票了");
        }

    }
}

class TicketHall1 {
    private volatile int num = 10;
    private Lock lock=new ReentrantLock();

    public int getNum() {
        return num;
    }

    public void poolNum(int num) {
        lock.lock();
        this.num -= num;
        lock.unlock();
    }
}

public class Main1 {
    public static void main(String[] args) {
        TicketHall1 ticketHall = new TicketHall1();
        Thread thread1 = new Thread(new Person1(ticketHall), "线程1");
        Thread thread2 = new Thread(new Person1(ticketHall), "线程2");
        thread1.start();
        thread2.start();
    }
}
