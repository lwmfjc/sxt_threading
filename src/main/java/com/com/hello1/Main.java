package com.com.hello1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new TaskMing1());//使用线程池让小明跑步
        service.shutdown();
    }
}
