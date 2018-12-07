package com.learning.java.lock;

public class LockDemo {

    public static void main(String[] args) throws InterruptedException {
        QueueBuffer queueBuffer = new QueueBuffer();
        Producer producer = new Producer(queueBuffer);
        Consumer consumer = new Consumer(queueBuffer);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.setKeepRunning(false);
        consumer.setKeepRunning(false);
    }

}
