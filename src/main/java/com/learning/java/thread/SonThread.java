package com.learning.java.thread;

public class SonThread extends Thread {

    public void run() {
        System.out.println("\tSon goes out to buy cigarettes and this will take 10 minutes");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("\tTime costing: " + (i + 1) + " min");
            }
        } catch (InterruptedException e) {
            System.out.println("\tSomething wrong happens when Son is outing");
        }
        System.out.println("\tSon is back with cigarettes");
    }

}
