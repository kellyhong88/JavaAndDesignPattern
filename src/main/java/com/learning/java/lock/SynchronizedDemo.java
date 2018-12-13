package com.learning.java.lock;

/**
 * synchronized 是一种互斥锁，即一次只允许一个线程获得锁，从而执行被锁住的代码块
 *
 * synchronized 是一种内置锁（intrinsic lock）/ 监视器锁（monitor）
 * Java中每个对象都有一个内置锁/监视器，而synchronized就是使用对象的内置锁(监视器)来将代码块/方法锁定的
 *
 * synchronized 修饰静态方法，获取的是类锁（类的字节码文件对象）
 * synchronized 修饰普通方法/代码块，获取的是对象锁（对象的内置锁）
 *
 * 🚩类锁与对象锁是不冲突的！也就是说，获取了类锁的线程和获取了对象锁的线程是不冲突的
 */
public class SynchronizedDemo {

    //synchronized修饰静态方法
    public static synchronized void staticFunction() {
        for (int i = 0; i < 5;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Static function running for turn: " + (++i));
        }
    }

    //synchronized修饰非静态方法
    public synchronized void function() {
        for (int i = 0; i < 5;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Function running for turn: " + (++i));
        }
    }

    public static void main(String[] args) {
        final SynchronizedDemo demo = new SynchronizedDemo();

        //创建线程执行静态方法，并启动线程
        new Thread(() -> {
            SynchronizedDemo.staticFunction();
        }).start();

        //创建线程执行实例方法，并启动线程
        new Thread(() -> {
            demo.function();
        }).start();
    }

}
