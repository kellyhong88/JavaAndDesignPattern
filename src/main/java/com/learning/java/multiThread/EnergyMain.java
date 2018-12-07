package com.learning.java.multiThread;

public class EnergyMain {

    public static void main(String[] args) {
        int boxNum = 10;
        double initialEnergyPerBox = 1000.00;

        EnergySystem energySystem = new EnergySystem(boxNum, initialEnergyPerBox);

        EnergyTransferTask task1 = new EnergyTransferTask(energySystem, 0);
        new Thread(task1, "盒子[0]转移任务").start();

        EnergyTransferTask task2 = new EnergyTransferTask(energySystem, 4);
        new Thread(task2, "盒子[4]转移任务").start();

        EnergyTransferTask task3 = new EnergyTransferTask(energySystem, 9);
        new Thread(task3, "盒子[9]转移任务").start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task1.setKeepRunning(false);
        task2.setKeepRunning(false);
        task3.setKeepRunning(false);
        System.out.println("Transfer tasks end");

    }

}
