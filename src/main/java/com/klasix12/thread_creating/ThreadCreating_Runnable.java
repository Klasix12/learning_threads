package com.klasix12.thread_creating;

public class ThreadCreating_Runnable {
    static class NewThread implements Runnable {
        Thread t;

        NewThread() {
            t = new Thread(this, "Demo thread");
            System.out.println("Subthread: " + t);
        }

        @Override
        public void run() {
            try {
                for (int i = 5; i >= 1; i--) {
                    System.out.println("Subthread: " + i);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                System.out.println("Subthread interrupted");
            }
            System.out.println("Subthread exiting");
        }
    }

    public static void main(String[] args) {
        NewThread thread = new NewThread();
        thread.t.start();
        try {
            for (int i = 5; i >= 1; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}


