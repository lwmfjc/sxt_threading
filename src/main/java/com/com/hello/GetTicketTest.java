package com.com.hello;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 取票的任务
 */
public class GetTicketTest {

    public static void main(String[] args) {
        TicketHall ticketHall = new TicketHall();
        Runnable task = new TaskGetTicket(ticketHall);
        Thread t1 = new Thread(task, "小明");
        Thread t2 = new Thread(task, "小红");
        t1.start();
        t2.start();
    }
}

class TicketHall {
    private int ticketNum = 100;//总共一百张票

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }
}

class TaskGetTicket implements Runnable {
    private TicketHall ticketHall;//售票大厅
    private Lock lock = new ReentrantLock();

    public TaskGetTicket(TicketHall ticketHall) {
        this.ticketHall = ticketHall;
    }

    public void run() {
        while (true) {
            //来售票大厅取票
            lock.lock();
            try {
                if (ticketHall.getTicketNum() > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("'" + Thread.currentThread().getName() + "'取走了票" + ticketHall.getTicketNum());
                    ticketHall.setTicketNum(ticketHall.getTicketNum() - 1);
                } else {
                    System.out.println("没取到票...555");
                    break;
                }
            } finally {
                lock.unlock();//去锁
            }
        }
    }
}


