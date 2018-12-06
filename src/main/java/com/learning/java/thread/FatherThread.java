package com.learning.java.thread;

public class FatherThread extends Thread {

    public void run() {
        System.out.println("Father wants to smoke and then ask his son to buy cigarettes");
        Thread son = new SonThread();
        son.start();
        System.out.println("Father is waiting for his son to get cigarettes home");
        try {
            //join含义：等待son线程执行完毕，father线程才继续执行
            son.join();
        } catch (InterruptedException e) {
            System.out.println("Father goes out to find where his son is");
        }
        System.out.println("Father takes cigarettes from his son happily");
    }

}
