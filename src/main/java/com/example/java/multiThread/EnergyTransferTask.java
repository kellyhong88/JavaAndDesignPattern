package com.example.java.multiThread;

/**
 * 能量转移任务(线程类)
 */
public class EnergyTransferTask implements Runnable {

    volatile static boolean keepRunning = true;

    /**
     * 共享的能量世界
     */
    private EnergySystem energySystem;

    private int fromBox;

    /**
     * 单次最大转移能量单元
     */
    private final double MAX_AMOUNT = 10000.00;

    /**
     * 最大休眠时间(毫秒)
     */
    private final int MAX_DALEY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int fromBox) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
    }

    public void run() {
        try {
            while (keepRunning) {
                /**
                 * Math.random()是令系统返回[0.0,1.0)的伪随机double值
                 * */
                int toBox = (int) (energySystem.getNumberOfBoxes() * Math.random());
                double amount = MAX_AMOUNT * Math.random();
                energySystem.transfer(fromBox, toBox, amount);
                Thread.sleep((int) (MAX_DALEY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        int boxNum = 100;
        double initialEnergyPerBox = 1000.00;

        EnergySystem energySystem = new EnergySystem(boxNum, initialEnergyPerBox);
        for (int i = 0; i < boxNum; i++) {
            EnergyTransferTask task = new EnergyTransferTask(energySystem, i);
            Thread thread = new Thread(task, "盒子[" + String.valueOf(i) + "]转移任务");
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keepRunning = false;
    }
}
