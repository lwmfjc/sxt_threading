package com.com.hello5;


import com.com.hello3.Producer;
import javafx.concurrent.Task;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Product implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        //生成一个随机数
        return new Random().nextInt(10);
    }
}

public class Main {
    public static void main(String[] args) {
        // while (true){
        FutureTask<Integer> task = new FutureTask<Integer>(new Product());
        new Thread(task).start();
        try {
            //会阻塞
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("------------");
        // }
    }
}
