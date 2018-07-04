package com.example.java.thread;

import java.util.concurrent.*;

public class CallableAndCompletionService {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);

        for (int i = 0; i < 10; i++) {

            final int index = i;
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return index;
                }
            };

            completionService.submit(callable);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                System.out.println("Task: " + completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}
