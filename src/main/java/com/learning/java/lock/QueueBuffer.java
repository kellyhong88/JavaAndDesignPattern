package com.learning.java.lock;

/**
 * 1. 任何对象都有一把自己的固有锁(intrinsic lock)，也有自己的固有条件队列(intrinsic condition queue)
 *    而这个对象里的 wait(), notify(), notifyAll() 则是这个条件队列的固有(intrinsic)方法
 *
 * 2. 一个对象的固有锁和它的固有条件队列是相关的，为了调用对象X内条件队列的方法，你必须获得对象X的锁
 *    这是因为等待状态条件的机制和保证状态连续性的机制是紧密结合在一起的
 *
 *    An object's intrinsic lock and its intrinsic condition queue are related.
 *
 *    In order to call any of the condition queue methods (wait(), notify(), notifyAll()) on object X,
 *    you must hold the lock on object X.
 *
 *    This is because the mechanism for waiting for state-based conditions is tightly bound to the mechanism for preserving state consistency.
 * */
public class QueueBuffer {

    private int value;

    private boolean isValueSet = false;

    /** 'synchronized' on method means competing for the lock of the current object (this instance of QueueBuffer) */
    synchronized void put(int newValue) {
        /*
         * if value is not yet set, producer should go to set the value instead of waiting
         * if value is already set, producer should wait until consumer notify him to go back working
         * */
        if (isValueSet) {
            waiting();
        }

        producerWorking(newValue);

        /** notify another thread waiting on the condition queue of the current object (this instance of QueueBuffer)
         *  and the thread notified will compete for the lock of the current object and may be runnable again */
        this.notify();
    }

    private void waiting() {
        try {
            /** wait on the condition queue of the current object (this instance of QueueBuffer) */
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void producerWorking(int newValue) {
        this.value = newValue;
        isValueSet = true;
        System.out.println("Producer put value: " + this.value);
    }

    synchronized void get() {
        /*
         * if value is not yet set, consumer should wait until producer notify him to go back working
         * if value is already set, consumer should go to consume the value instead of waiting
         * */
        if (!isValueSet) {
            waiting();
        }

        consumerWorking();

        this.notify();
    }

    private void consumerWorking() {
        System.out.println("Consumer get value: " + this.value);
        isValueSet = false;
    }

}
