package com.klasix12.isAlive_and_join;

public class Main {
    static class NewThread implements Runnable {
        String name;
        Thread t;

        NewThread(String name) {
            this.name = name;
            t = new Thread(this, name);
            System.out.println("New Thread: " + name);
        }

        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(name + ": " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
            System.out.println(name + " exiting");
        }
    }

    public static void main(String[] args) {
        NewThread nt1 = new NewThread("one");
        NewThread nt2 = new NewThread("two");
        NewThread nt3 = new NewThread("three");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Thread one " + nt1.t.isAlive());
        System.out.println("Thread two " + nt2.t.isAlive());
        System.out.println("Thread three " + nt3.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Thread one " + nt1.t.isAlive());
        System.out.println("Thread two " + nt2.t.isAlive());
        System.out.println("Thread three " + nt3.t.isAlive());
        System.out.println("Main thread interrupted");
    }
}
