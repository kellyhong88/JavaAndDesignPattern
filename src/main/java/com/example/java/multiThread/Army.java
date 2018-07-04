package com.example.java.multiThread;

/**
 * 军队线程类
 * 模拟作战双方的行为
 */
public class Army implements Runnable {

    /**
     * volatile变量可以实现线程共享
     */
    volatile boolean fighting = true;

    public void run() {
        while (fighting) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " attack: " + i);
                /**
                 * 让出CPU，从running状态进入runnable状态，
                 * 等待被调度器再次调度（可能调度别人，也可能还是调度自己）
                 */
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + " end fighting");
    }

}
