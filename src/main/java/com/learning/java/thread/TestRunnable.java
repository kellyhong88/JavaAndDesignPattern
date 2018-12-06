package com.learning.java.thread;

public class TestRunnable {

    public static void main(String args[]) {
        System.out.println("Main thread starts running");

        RunnableDemo r1 = new RunnableDemo("thread-1");
        RunnableDemo r2 = new RunnableDemo("thread-2");

        r1.start();
        r2.start();

        System.out.println("Main thread exists");
    }
}

class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 1; i < 9; i++) {
                System.out.println("Thread " + threadName + " sleep for turn " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + "interrupted");
        }
        System.out.println("Thread " + threadName + " existing");
    }
}
