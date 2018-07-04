package com.learning.java.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTask {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        /**
         * FutureTask实现了Runnable和Future两个接口
         * 因此FutureTask既可作为Runnable被线程执行，也可作为Future得到Callable的返回值
         * */
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        /**
         * FutureTask作为Runnable被线程执行
         * */
        new Thread(futureTask).start();

        try {
            Thread.sleep(2000);
            /**
             * FutureTask作为Future得到Callable的返回值
             * */
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
