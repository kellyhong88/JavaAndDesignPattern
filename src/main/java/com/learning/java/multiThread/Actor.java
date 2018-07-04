package com.learning.java.multiThread;

/**
 * 继承Tread类
 */
public class Actor extends Thread {

    public Actor(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " starts performing!");

        int count = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println(getName() + "'s show: " + (++count));
            if (count == 10)
                keepRunning = false;
            if (count % 2 == 0)
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(getName() + " stops performing!");
    }
}
