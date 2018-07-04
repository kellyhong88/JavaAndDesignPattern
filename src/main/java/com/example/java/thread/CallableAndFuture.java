package com.example.java.thread;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        /**
         * Callable和Runnable区别
         * 1. Callable接口中声明的方法是call()，Runnable接口中声明的方法是run()
         * 2. Callable任务执行后有返回值，Runnable任务执行后没有返回值
         * 3. call()方法可以抛出异常，run()方法不可以抛出异常
         * 4. Callable任务执行之后可以拿到一个Future对象，表示异步计算的结果
         * */
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        Future<Integer> future = threadPool.submit(callable);

        try {
            Thread.sleep(2000);
            /**
             * Future和FutureTask的使用场景：
             * 如果有一个返回值计算很耗时，且这个返回值并不是马上需要的话，
             * 就可以使用Future或FutureTask。
             * 用另一个线程去计算返回值，
             * 而当前线程在使用这个返回值之前可以做其它的操作，
             * 直到需要使用这个返回值时，再通过Future得到，岂不美哉！
             * */
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
    }

}
