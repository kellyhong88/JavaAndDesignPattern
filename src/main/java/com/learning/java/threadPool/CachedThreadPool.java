package com.learning.java.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i + 1;

            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            };

            cachedThreadPool.execute(runnable);
        }

        cachedThreadPool.shutdown();
    }
}
