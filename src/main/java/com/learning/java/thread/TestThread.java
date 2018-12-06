package com.learning.java.thread;

public class TestThread {

    public static void main(String args[]) {
        System.out.println("Main thread starts running");

        ThreadDemo t1 = new ThreadDemo("thread-1");
        ThreadDemo t2 = new ThreadDemo("thread-2");

        t1.start();
        t2.start();

        System.out.println("Main thread exists");
    }
}

class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;

    public ThreadDemo(String threadName) {
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

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 1; i < 10; i++) {
                System.out.println("Thread " + threadName + " sleep for turn " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + "interrupted");
        }
        System.out.println("Thread " + threadName + " existing");
    }
}
