package com.klasix12.thread_creating;

public class ThreadCreating_ThreadExtend  {
    static class NewThread extends Thread {
        NewThread() {
            super("Demo thread");
            System.out.println("Subthread: " + this);
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
        thread.start();
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
