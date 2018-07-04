package com.example.java.multiThread;

/**
 * 宇宙能量系统
 * 能量守恒定律：能量不会凭空创生或消失，只会从一处转移到另一处
 */
public class EnergySystem {

    /**
     * 能量盒子
     */
    private final double[] energyBoxes;

    /**
     * 同步锁
     * 实现互斥
     */
    private final Byte[] lock = new Byte[0];

    /**
     * @param numberOfBoxes:       能量盒子的数量
     * @param InitialEnergyPerBox: 每个能量盒子含有的初始能量值
     */
    public EnergySystem(int numberOfBoxes, double InitialEnergyPerBox) {
        this.energyBoxes = new double[numberOfBoxes];
        for (int i = 0; i < energyBoxes.length; i++)
            energyBoxes[i] = InitialEnergyPerBox;
    }

    /**
     * 能量的转移，从一个盒子到另一个盒子
     *
     * @param from:   能量源
     * @param to:     能量终点
     * @param amount: 能量值
     */
    public void transfer(int from, int to, double amount) {

        if (from < 0 || from >= getNumberOfBoxes() || to < 0 || to >= getNumberOfBoxes())
            return;
        if (from == to)
            return;
        if (amount > getTotalEnergies())
            return;

        synchronized (lock) {

            /**
             * 保证条件不满足时任务会被阻挡，而不是继续竞争CPU资源
             * */
            if (energyBoxes[from] < amount) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            energyBoxes[from] -= amount;
            energyBoxes[to] += amount;
            System.out.printf("%s  从盒子[%d]转移到盒子[%d] %.2f单元能量。  能量总和：%.2f%n",
                    Thread.currentThread().getName(), from, to, amount, getTotalEnergies());

            /**
             * 唤醒所有在lock对象上等待的线程
             * */
//            lock.notify();
            lock.notifyAll();

        }

    }

    /**
     * 获取宇宙能量总和
     */
    public double getTotalEnergies() {
        double sum = 0;
        for (double amount : energyBoxes)
            sum += amount;
        return sum;
    }

    /**
     * 获取能量盒子数量
     */
    public int getNumberOfBoxes() {
        return energyBoxes.length;
    }

}
