package com.learning.java.multiThread;

/**
 * 关键人物线程类
 */
public class KeyPerson extends Thread {

    public KeyPerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(getName() + " fights bravely: " + i);
            yield();
        }
    }
}
