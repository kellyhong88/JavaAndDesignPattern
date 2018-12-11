package com.learning.java.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {

    public static void main(String[] args) {

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i + 1;

            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        singleThreadPool.shutdown();
    }
}
