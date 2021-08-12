package com.com.hello_rw;

public class Task implements Runnable {

    private MyOpt opt;

    public Task(MyOpt opt) {
        this.opt = opt;
    }

    public void run() {
        this.opt.read();
        this.opt.write();
    }
}
