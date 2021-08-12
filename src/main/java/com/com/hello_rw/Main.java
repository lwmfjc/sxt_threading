package com.com.hello_rw;

public class Main {
    public static void main(String[] args) {
        Task task=new Task(new MyOpt());
        for(int i=0;i<10;i++){
            new Thread(task).start();
        }
    }
}
