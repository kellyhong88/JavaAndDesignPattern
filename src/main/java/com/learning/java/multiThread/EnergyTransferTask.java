package com.learning.java.multiThread;

import lombok.Setter;

/**
 * 能量转移任务(线程类)
 */
@Setter
public class EnergyTransferTask implements Runnable {

    volatile boolean keepRunning = true;

    /**
     * 共享的能量世界
     */
    private EnergySystem energySystem;

    private int fromBox;

    /**
     * 单次最大转移能量单元
     */
    private final double MAX_AMOUNT = 10.00;

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

}
