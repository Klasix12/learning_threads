package com.klasix12.start_and_run_diff;

public class ThreadsStartAndRunDif {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1. Current thread name: " + Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2. Current thread name: " + Thread.currentThread().getName());
        });

        thread1.run();
        thread2.start();
    }
}
