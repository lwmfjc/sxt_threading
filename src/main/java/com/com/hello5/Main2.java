package com.com.hello5;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

class MyRun implements Runnable {
    int i;

    public MyRun(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}

class MyCall implements Callable<String> {
    String s;

    public MyCall(String s) {
        this.s = s;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return new Random().nextInt(100) + s;
    }
}

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ArrayList<Future<String>> arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            System.out.println(service.submit(new MyCall("[" + i + "]")).get());
            //arrayList.add(service.submit(new MyCall("[" + i + "]")));
        }
        service.shutdown();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).get());
        }
    }
}
