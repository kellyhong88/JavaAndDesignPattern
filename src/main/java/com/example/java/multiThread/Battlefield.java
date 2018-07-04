package com.example.java.multiThread;

/**
 * 战场线程类
 */
public class Battlefield extends Thread {

    @Override
    public void run() {
        Army starkArmy = new Army();
        Army lannisterArmy = new Army();

        Thread starkThread = new Thread(starkArmy, "House Stark");
        Thread lannisterThread = new Thread(lannisterArmy, "House Lannister");

        System.out.println("War starts -------------------");

        starkThread.start();
        lannisterThread.start();

        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Suddenly, the king in the North shows up ------------");

        Thread keyPerson = new KeyPerson("Young wolf");
        keyPerson.start();

        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        starkArmy.fighting = false;
        lannisterArmy.fighting = false;

        try {
            keyPerson.join();
            starkThread.join();
            lannisterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("War ends -------------------");
    }

    public static void main(String[] args) {
        new Battlefield().start();
    }
}
